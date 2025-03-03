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
@file:Suppress("MagicNumber", "TooManyFunctions")

package com.ashampoo.kim.common

/**
 * Convenience methods for converting data types to and from
 * byte arrays.
 */

@Suppress("MagicNumber")
fun Byte.toUInt8(): Int = 0xFF and toInt()

fun Short.toBytes(byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(2)

    this.toBytes(byteOrder, result, 0)

    return result
}

fun ShortArray.toBytes(byteOrder: ByteOrder): ByteArray =
    this.toBytes(0, size, byteOrder)

private fun ShortArray.toBytes(offset: Int, length: Int, byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(length * 2)

    for (index in 0 until length)
        this[offset + index].toBytes(byteOrder, result, index * 2)

    return result
}

private fun Short.toBytes(byteOrder: ByteOrder, result: ByteArray, offset: Int) {

    if (byteOrder == ByteOrder.BIG_ENDIAN) {
        result[offset + 0] = (toInt() shr 8).toByte()
        result[offset + 1] = (toInt() shr 0).toByte()
    } else {
        result[offset + 1] = (toInt() shr 8).toByte()
        result[offset + 0] = (toInt() shr 0).toByte()
    }
}

fun Int.toBytes(byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(4)
    this.toBytes(byteOrder, result, 0)
    return result
}

fun IntArray.toBytes(byteOrder: ByteOrder): ByteArray =
    this.toBytes(0, size, byteOrder)

private fun IntArray.toBytes(offset: Int, length: Int, byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(length * 4)

    for (i in 0 until length)
        this[offset + i].toBytes(byteOrder, result, i * 4)

    return result
}

private fun Int.toBytes(byteOrder: ByteOrder, result: ByteArray, offset: Int) {

    if (byteOrder == ByteOrder.BIG_ENDIAN) {
        result[offset + 0] = (this shr 24).toByte()
        result[offset + 1] = (this shr 16).toByte()
        result[offset + 2] = (this shr 8).toByte()
        result[offset + 3] = (this shr 0).toByte()
    } else {
        result[offset + 3] = (this shr 24).toByte()
        result[offset + 2] = (this shr 16).toByte()
        result[offset + 1] = (this shr 8).toByte()
        result[offset + 0] = (this shr 0).toByte()
    }
}

fun Float.toBytes(byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(4)
    this.toBytes(byteOrder, result, 0)
    return result
}

fun FloatArray.toBytes(byteOrder: ByteOrder): ByteArray =
    this.toBytes(0, size, byteOrder)

private fun FloatArray.toBytes(offset: Int, length: Int, byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(length * 4)

    for (i in 0 until length)
        this[offset + i].toBytes(byteOrder, result, i * 4)

    return result
}

private fun Float.toBytes(byteOrder: ByteOrder, result: ByteArray, offset: Int) {

    val bits = toRawBits()

    if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
        result[offset + 0] = (0xFF and (bits shr 0)).toByte()
        result[offset + 1] = (0xFF and (bits shr 8)).toByte()
        result[offset + 2] = (0xFF and (bits shr 16)).toByte()
        result[offset + 3] = (0xFF and (bits shr 24)).toByte()
    } else {
        result[offset + 3] = (0xFF and (bits shr 0)).toByte()
        result[offset + 2] = (0xFF and (bits shr 8)).toByte()
        result[offset + 1] = (0xFF and (bits shr 16)).toByte()
        result[offset + 0] = (0xFF and (bits shr 24)).toByte()
    }
}

fun Double.toBytes(byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(8)

    this.toBytes(byteOrder, result, 0)

    return result
}

fun DoubleArray.toBytes(byteOrder: ByteOrder): ByteArray =
    this.toBytes(0, size, byteOrder)

private fun DoubleArray.toBytes(offset: Int, length: Int, byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(length * 8)

    for (i in 0 until length)
        this[offset + i].toBytes(byteOrder, result, i * 8)

    return result
}

private fun Double.toBytes(byteOrder: ByteOrder, result: ByteArray, offset: Int) {

    val bits = toRawBits()

    if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
        result[offset + 0] = (0xFFL and (bits shr 0)).toByte()
        result[offset + 1] = (0xFFL and (bits shr 8)).toByte()
        result[offset + 2] = (0xFFL and (bits shr 16)).toByte()
        result[offset + 3] = (0xFFL and (bits shr 24)).toByte()
        result[offset + 4] = (0xFFL and (bits shr 32)).toByte()
        result[offset + 5] = (0xFFL and (bits shr 40)).toByte()
        result[offset + 6] = (0xFFL and (bits shr 48)).toByte()
        result[offset + 7] = (0xFFL and (bits shr 56)).toByte()
    } else {
        result[offset + 7] = (0xFFL and (bits shr 0)).toByte()
        result[offset + 6] = (0xFFL and (bits shr 8)).toByte()
        result[offset + 5] = (0xFFL and (bits shr 16)).toByte()
        result[offset + 4] = (0xFFL and (bits shr 24)).toByte()
        result[offset + 3] = (0xFFL and (bits shr 32)).toByte()
        result[offset + 2] = (0xFFL and (bits shr 40)).toByte()
        result[offset + 1] = (0xFFL and (bits shr 48)).toByte()
        result[offset + 0] = (0xFFL and (bits shr 56)).toByte()
    }
}

fun RationalNumber.toBytes(byteOrder: ByteOrder): ByteArray {

    val result = ByteArray(8)

    this.toBytes(byteOrder, result, 0)

    return result
}

fun Array<out RationalNumber>.toBytes(byteOrder: ByteOrder): ByteArray =
    this.toBytes(0, size, byteOrder)

private fun Array<out RationalNumber>.toBytes(
    offset: Int,
    length: Int,
    byteOrder: ByteOrder
): ByteArray {

    val result = ByteArray(length * 8)

    for (i in 0 until length)
        this[offset + i].toBytes(byteOrder, result, i * 8)

    return result
}

private fun RationalNumber.toBytes(byteOrder: ByteOrder, result: ByteArray, offset: Int) {

    if (byteOrder == ByteOrder.BIG_ENDIAN) {
        result[offset + 0] = (numerator shr 24).toByte()
        result[offset + 1] = (numerator shr 16).toByte()
        result[offset + 2] = (numerator shr 8).toByte()
        result[offset + 3] = (numerator shr 0).toByte()
        result[offset + 4] = (divisor shr 24).toByte()
        result[offset + 5] = (divisor shr 16).toByte()
        result[offset + 6] = (divisor shr 8).toByte()
        result[offset + 7] = (divisor shr 0).toByte()
    } else {
        result[offset + 3] = (numerator shr 24).toByte()
        result[offset + 2] = (numerator shr 16).toByte()
        result[offset + 1] = (numerator shr 8).toByte()
        result[offset + 0] = (numerator shr 0).toByte()
        result[offset + 7] = (divisor shr 24).toByte()
        result[offset + 6] = (divisor shr 16).toByte()
        result[offset + 5] = (divisor shr 8).toByte()
        result[offset + 4] = (divisor shr 0).toByte()
    }
}

fun ByteArray.toShort(byteOrder: ByteOrder): Short =
    toShort(0, byteOrder)

private fun ByteArray.toShort(offset: Int, byteOrder: ByteOrder): Short =
    toUInt16(offset, byteOrder).toShort()

fun ByteArray.toShorts(byteOrder: ByteOrder): ShortArray =
    toShorts(0, size, byteOrder)

private fun ByteArray.toShorts(offset: Int, length: Int, byteOrder: ByteOrder): ShortArray {

    val result = ShortArray(length / 2)

    for (i in result.indices)
        result[i] = toShort(offset + 2 * i, byteOrder)

    return result
}

fun ByteArray.toUInt16(byteOrder: ByteOrder): Int =
    toUInt16(0, byteOrder)

fun ByteArray.toUInt16(offset: Int, byteOrder: ByteOrder): Int {

    val byte0 = 0xFF and this[offset + 0].toInt()
    val byte1 = 0xFF and this[offset + 1].toInt()

    return if (byteOrder == ByteOrder.BIG_ENDIAN)
        byte0 shl 8 or byte1
    else
        byte1 shl 8 or byte0
}

fun ByteArray.toUInt16s(byteOrder: ByteOrder): IntArray =
    this.toUInt16s(0, size, byteOrder)

private fun ByteArray.toUInt16s(offset: Int, length: Int, byteOrder: ByteOrder): IntArray {

    val result = IntArray(length / 2)

    repeat(result.size) { i ->
        result[i] = toUInt16(offset + 2 * i, byteOrder)
    }

    return result
}

fun ByteArray.toInt(byteOrder: ByteOrder): Int =
    this.toInt(0, byteOrder)

fun ByteArray.toInt(offset: Int, byteOrder: ByteOrder): Int {

    val byte0 = 0xFF and this[offset + 0].toInt()
    val byte1 = 0xFF and this[offset + 1].toInt()
    val byte2 = 0xFF and this[offset + 2].toInt()
    val byte3 = 0xFF and this[offset + 3].toInt()

    return if (byteOrder == ByteOrder.BIG_ENDIAN)
        byte0 shl 24 or (byte1 shl 16) or (byte2 shl 8) or byte3
    else
        byte3 shl 24 or (byte2 shl 16) or (byte1 shl 8) or byte0
}

fun ByteArray.toInts(byteOrder: ByteOrder): IntArray =
    this.toInts(0, size, byteOrder)

private fun ByteArray.toInts(offset: Int, length: Int, byteOrder: ByteOrder): IntArray {

    val result = IntArray(length / 4)

    repeat(result.size) { i ->
        result[i] = toInt(offset + 4 * i, byteOrder)
    }

    return result
}

fun ByteArray.toFloat(byteOrder: ByteOrder): Float =
    this.toFloat(0, byteOrder)

private fun ByteArray.toFloat(offset: Int, byteOrder: ByteOrder): Float {

    val byte0 = 0xFF and this[offset + 0].toInt()
    val byte1 = 0xFF and this[offset + 1].toInt()
    val byte2 = 0xFF and this[offset + 2].toInt()
    val byte3 = 0xFF and this[offset + 3].toInt()

    val bits = if (byteOrder == ByteOrder.BIG_ENDIAN)
        byte0 shl 24 or (byte1 shl 16) or (byte2 shl 8) or (byte3 shl 0)
    else
        byte3 shl 24 or (byte2 shl 16) or (byte1 shl 8) or (byte0 shl 0)

    return Float.fromBits(bits)
}

fun ByteArray.toFloats(byteOrder: ByteOrder): FloatArray =
    this.toFloats(0, size, byteOrder)

private fun ByteArray.toFloats(offset: Int, length: Int, byteOrder: ByteOrder): FloatArray {

    val result = FloatArray(length / 4)

    for (i in result.indices)
        result[i] = toFloat(offset + 4 * i, byteOrder)

    return result
}

fun ByteArray.toDouble(byteOrder: ByteOrder): Double =
    this.toDouble(0, byteOrder)

private fun ByteArray.toDouble(offset: Int, byteOrder: ByteOrder): Double {

    val byte0 = 0xFFL and this[offset + 0].toLong()
    val byte1 = 0xFFL and this[offset + 1].toLong()
    val byte2 = 0xFFL and this[offset + 2].toLong()
    val byte3 = 0xFFL and this[offset + 3].toLong()
    val byte4 = 0xFFL and this[offset + 4].toLong()
    val byte5 = 0xFFL and this[offset + 5].toLong()
    val byte6 = 0xFFL and this[offset + 6].toLong()
    val byte7 = 0xFFL and this[offset + 7].toLong()

    val bits: Long
    bits = if (byteOrder == ByteOrder.BIG_ENDIAN) {
        (
            byte0 shl 56 or (byte1 shl 48) or (byte2 shl 40)
                or (byte3 shl 32) or (byte4 shl 24) or (byte5 shl 16)
                or (byte6 shl 8) or (byte7 shl 0)
            )
    } else {
        (
            byte7 shl 56 or (byte6 shl 48) or (byte5 shl 40)
                or (byte4 shl 32) or (byte3 shl 24) or (byte2 shl 16)
                or (byte1 shl 8) or (byte0 shl 0)
            )
    }

    return Double.fromBits(bits)
}

fun ByteArray.toDoubles(byteOrder: ByteOrder): DoubleArray =
    this.toDoubles(0, size, byteOrder)

private fun ByteArray.toDoubles(offset: Int, length: Int, byteOrder: ByteOrder): DoubleArray {

    val result = DoubleArray(length / 8)

    repeat(result.size) { i ->
        result[i] = toDouble(offset + 8 * i, byteOrder)
    }

    return result
}

fun ByteArray.toRational(byteOrder: ByteOrder, unsignedType: Boolean): RationalNumber =
    this.toRational(0, byteOrder, unsignedType)

private fun ByteArray.toRational(
    offset: Int,
    byteOrder: ByteOrder,
    unsignedType: Boolean
): RationalNumber {

    val byte0 = 0xFF and this[offset + 0].toInt()
    val byte1 = 0xFF and this[offset + 1].toInt()
    val byte2 = 0xFF and this[offset + 2].toInt()
    val byte3 = 0xFF and this[offset + 3].toInt()
    val byte4 = 0xFF and this[offset + 4].toInt()
    val byte5 = 0xFF and this[offset + 5].toInt()
    val byte6 = 0xFF and this[offset + 6].toInt()
    val byte7 = 0xFF and this[offset + 7].toInt()

    val numerator: Int
    val divisor: Int

    if (byteOrder == ByteOrder.BIG_ENDIAN) {
        numerator = byte0 shl 24 or (byte1 shl 16) or (byte2 shl 8) or byte3
        divisor = byte4 shl 24 or (byte5 shl 16) or (byte6 shl 8) or byte7
    } else {
        numerator = byte3 shl 24 or (byte2 shl 16) or (byte1 shl 8) or byte0
        divisor = byte7 shl 24 or (byte6 shl 16) or (byte5 shl 8) or byte4
    }

    return RationalNumber(numerator, divisor, unsignedType)
}

fun ByteArray.toRationals(
    byteOrder: ByteOrder,
    unsignedType: Boolean
): Array<RationalNumber> =
    toRationals(this, 0, size, byteOrder, unsignedType)

private fun toRationals(
    bytes: ByteArray,
    offset: Int,
    length: Int,
    byteOrder: ByteOrder,
    unsignedType: Boolean
): Array<RationalNumber> {

    val result = arrayOfNulls<RationalNumber>(length / 8)

    repeat(result.size) { i ->
        result[i] = bytes.toRational(offset + 8 * i, byteOrder, unsignedType)
    }

    return result as Array<RationalNumber>
}

fun Int.quadsToByteArray(): ByteArray {

    val bytes = ByteArray(4)

    bytes[0] = (this shr 24).toByte()
    bytes[1] = (this shr 16).toByte()
    bytes[2] = (this shr 8).toByte()
    bytes[3] = toByte()

    return bytes
}
