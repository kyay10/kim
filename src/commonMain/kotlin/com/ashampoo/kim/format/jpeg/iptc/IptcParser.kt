/*
 * Copyright 2023 Ashampoo GmbH & Co. KG
 * Copyright 2007-2023 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ashampoo.kim.format.jpeg.iptc

import com.ashampoo.kim.common.BinaryFileParser
import com.ashampoo.kim.common.ByteOrder
import com.ashampoo.kim.common.ImageReadException
import com.ashampoo.kim.common.slice
import com.ashampoo.kim.common.startsWith
import com.ashampoo.kim.common.toInt
import com.ashampoo.kim.common.toUInt16
import com.ashampoo.kim.common.toUInt8
import com.ashampoo.kim.format.jpeg.JpegConstants
import com.ashampoo.kim.format.jpeg.iptc.IptcTypes.Companion.getIptcType
import com.ashampoo.kim.input.ByteArrayByteReader
import io.ktor.utils.io.charsets.Charset
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String

object IptcParser : BinaryFileParser() {

    val EMPTY_BYTE_ARRAY = byteArrayOf()

    /**
     * Block types (or Image Resource IDs) that are not recommended to be
     * interpreted when libraries process Photoshop IPTC metadata.
     *
     * @see https://www.adobe.com/devnet-apps/photoshop/fileformatashtml/
     */
    @Suppress("MagicNumber")
    private val PHOTOSHOP_IGNORED_BLOCK_TYPE = listOf(1084, 1085, 1086, 1087)

    val DEFAULT_CHARSET = Charsets.ISO_8859_1

    const val ENV_TAG_CODED_CHARACTER_SET = 90

    val UTF8_CHARACTER_ESCAPE_SEQUENCE =
        byteArrayOf('\u001B'.code.toByte(), '%'.code.toByte(), 'G'.code.toByte())

    val APP13_BYTE_ORDER = ByteOrder.BIG_ENDIAN

    init {
        byteOrder = APP13_BYTE_ORDER
    }

    fun isIptcSegment(segmentData: ByteArray): Boolean {

        if (!segmentData.startsWith(JpegConstants.PHOTOSHOP_IDENTIFICATION_STRING))
            return false

        val index = JpegConstants.PHOTOSHOP_IDENTIFICATION_STRING.size

        return index + 4 <= segmentData.size &&
            segmentData.toInt(index, APP13_BYTE_ORDER) == JpegConstants.CONST_8BIM
    }

    fun parseIptc(bytes: ByteArray): IptcMetadata {

        val records = mutableListOf<IptcRecord>()

        val blocks = parseAllIptcBlocks(bytes)

        for (block in blocks) {

            /* Ignore everything but IPTC data. */
            if (!block.isIPTCBlock())
                continue

            records.addAll(parseIPTCBlock(block.blockData))
        }

        return IptcMetadata(records, blocks)
    }

    private fun parseIPTCBlock(bytes: ByteArray): List<IptcRecord> {

        var charset = DEFAULT_CHARSET

        val records = mutableListOf<IptcRecord>()

        var index = 0

        while (index + 1 < bytes.size) {

            val tagMarker = bytes[index++].toUInt8()

            /* We look after the IPTC record tag marker to read. */
            if (tagMarker != IptcConstants.IPTC_RECORD_TAG_MARKER)
                continue

            val recordNumber = bytes[index++].toUInt8()
            val recordType = bytes[index].toUInt8()
            index++

            val recordSize = bytes.toUInt16(index, byteOrder)
            index += 2

            val extendedDataset = recordSize > IptcConstants.IPTC_NON_EXTENDED_RECORD_MAXIMUM_SIZE

            /* Ignore extended dataset and everything after. */
            if (extendedDataset)
                return records

            val recordData = bytes.slice(index, recordSize)
            index += recordSize

            if (recordNumber == IptcConstants.IPTC_ENVELOPE_RECORD_NUMBER &&
                recordType == ENV_TAG_CODED_CHARACTER_SET
            ) {
                charset = findCharset(recordData)
                continue
            }

            if (recordNumber != IptcConstants.IPTC_APPLICATION_2_RECORD_NUMBER)
                continue

            if (recordType == 0)
                continue

            val value = String(recordData, charset = charset)

            val iptcType = getIptcType(recordType)

            val record = IptcRecord(iptcType, value)

            records.add(record)
        }

        return records
    }

    private fun parseAllIptcBlocks(bytes: ByteArray): List<IptcBlock> {

        val blocks = mutableListOf<IptcBlock>()

        val byteReader = ByteArrayByteReader(bytes)

        /*
         * Note that these are unsigned quantities. Name is always an even
         * number of bytes (including the 1st byte, which is the size.)
         */
        val idString = byteReader.readBytes(
            "App13 Segment identifier",
            JpegConstants.PHOTOSHOP_IDENTIFICATION_STRING.size
        )

        if (!JpegConstants.PHOTOSHOP_IDENTIFICATION_STRING.contentEquals(idString))
            throw ImageReadException(
                "Not a Photoshop App13 Segment: ${idString.contentToString()} " +
                    " != " + JpegConstants.PHOTOSHOP_IDENTIFICATION_STRING.contentToString()
            )

        while (true) {

            val resourceBlockSignature: Int = try {
                byteReader.read4BytesAsInt("Image Resource Block Signature", APP13_BYTE_ORDER)
            } catch (ignore: ImageReadException) {
                break
            }

            if (resourceBlockSignature != JpegConstants.CONST_8BIM)
                throw ImageReadException("Invalid Image Resource Block Signature: $resourceBlockSignature")

            val blockType = byteReader.read2BytesAsInt("IPTC block type", APP13_BYTE_ORDER)

            /*
             * Skip blocks that the photoshop spec recommends to.
             *
             * See discussion on https://issues.apache.org/jira/browse/IMAGING-246
             */
            if (PHOTOSHOP_IGNORED_BLOCK_TYPE.contains(blockType)) {

                /*
                 * If there is still data in this block, before the next image resource block (8BIM),
                 * then we must consume these bytes to leave a pointer ready to read the next block.
                 */
                byteReader.skipToQuad(JpegConstants.CONST_8BIM)

                continue
            }

            val blockNameLength = byteReader.readByte("block name length").toInt()

            var blockNameBytes: ByteArray

            if (blockNameLength == 0) {

                byteReader.readByte("empty name")
                blockNameBytes = EMPTY_BYTE_ARRAY

            } else {

                blockNameBytes = try {
                    byteReader.readBytes("block name bytes", blockNameLength)
                } catch (ignore: ImageReadException) {
                    break
                }

                if (blockNameLength % 2 == 0)
                    byteReader.readByte("block name padding byte")
            }

            val blockSize = byteReader.read4BytesAsInt("block size", APP13_BYTE_ORDER)

            /*
             * Note: This doesn't catch cases where blocksize is invalid but is still less
             * than "bytes.size", but will at least prevent OutOfMemory errors.
             */
            if (blockSize > bytes.size)
                throw ImageReadException("Invalid Block Size : " + blockSize + " > " + bytes.size)

            val blockData: ByteArray = try {
                byteReader.readBytes("block data", blockSize)
            } catch (ignore: ImageReadException) {
                break
            }

            blocks.add(IptcBlock(blockType, blockNameBytes, blockData))

            if (blockSize % 2 != 0)
                byteReader.readByte("block data padding byte")
        }

        return blocks
    }

    private fun findCharset(codedCharset: ByteArray): Charset {

        /*
         * check if encoding is a escape sequence
         * normalize encoding byte sequence
         */
        val codedCharsetNormalized = ByteArray(codedCharset.size)

        var index = 0
        for (element in codedCharset)
            if (element != ' '.code.toByte())
                codedCharsetNormalized[index++] = element

        val utf8 = UTF8_CHARACTER_ESCAPE_SEQUENCE.contentEquals(codedCharsetNormalized)

        return if (utf8) Charsets.UTF_8 else DEFAULT_CHARSET
    }
}
