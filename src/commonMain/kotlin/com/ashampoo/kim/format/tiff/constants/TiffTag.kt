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
package com.ashampoo.kim.format.tiff.constants

import com.ashampoo.kim.format.tiff.taginfos.TagInfo
import com.ashampoo.kim.format.tiff.taginfos.TagInfoAny
import com.ashampoo.kim.format.tiff.taginfos.TagInfoAscii
import com.ashampoo.kim.format.tiff.taginfos.TagInfoByteOrShort
import com.ashampoo.kim.format.tiff.taginfos.TagInfoBytes
import com.ashampoo.kim.format.tiff.taginfos.TagInfoLong
import com.ashampoo.kim.format.tiff.taginfos.TagInfoLongs
import com.ashampoo.kim.format.tiff.taginfos.TagInfoRational
import com.ashampoo.kim.format.tiff.taginfos.TagInfoRationals
import com.ashampoo.kim.format.tiff.taginfos.TagInfoShort
import com.ashampoo.kim.format.tiff.taginfos.TagInfoShortOrLong
import com.ashampoo.kim.format.tiff.taginfos.TagInfoShorts
import com.ashampoo.kim.format.tiff.taginfos.TagInfoUnknowns

/**
 * http://partners.adobe.com/public/developer/en/tiff/TIFF6.pdf
 */
@Suppress("MagicNumber", "VariableMaxLength", "UnderscoresInNumericLiterals")
object TiffTag {

    val TIFF_TAG_NEW_SUBFILE_TYPE = TagInfoLong(
        "NewSubfileType", 0xFE,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val SUBFILE_TYPE_VALUE_FULL_RESOLUTION_IMAGE = 0
    const val SUBFILE_TYPE_VALUE_REDUCED_RESOLUTION_IMAGE = 1
    const val SUBFILE_TYPE_VALUE_SINGLE_PAGE_OF_MULTI_PAGE_IMAGE = 2
    const val SUBFILE_TYPE_VALUE_SINGLE_PAGE_OF_MULTI_PAGE_REDUCED_RESOLUTION_IMAGE = 3
    const val SUBFILE_TYPE_VALUE_TRANSPARENCY_MASK = 4
    const val SUBFILE_TYPE_VALUE_TRANSPARENCY_MASK_OF_REDUCED_RESOLUTION_IMAGE = 5
    const val SUBFILE_TYPE_VALUE_TRANSPARENCY_MASK_OF_MULTI_PAGE_IMAGE = 6
    const val SUBFILE_TYPE_VALUE_TRANSPARENCY_MASK_OF_REDUCED_RESOLUTION_MULTI_PAGE_IMAGE = 7

    val TIFF_TAG_SUBFILE_TYPE = TagInfoShort(
        "SubfileType", 0xFF,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val OLD_SUBFILE_TYPE_VALUE_FULL_RESOLUTION_IMAGE = 1
    const val OLD_SUBFILE_TYPE_VALUE_REDUCED_RESOLUTION_IMAGE = 2
    const val OLD_SUBFILE_TYPE_VALUE_SINGLE_PAGE_OF_MULTI_PAGE_IMAGE = 3

    val TIFF_TAG_IMAGE_WIDTH = TagInfoShortOrLong(
        "ImageWidth", 0x100, 1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_IMAGE_LENGTH = TagInfoShortOrLong(
        "ImageLength", 0x101, 1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_BITS_PER_SAMPLE = TagInfoShorts(
        "BitsPerSample", 0x102, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_COMPRESSION = TagInfoShort(
        "Compression", 0x103,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val COMPRESSION_VALUE_UNCOMPRESSED = 1
    const val COMPRESSION_VALUE_CCITT_1D = 2
    const val COMPRESSION_VALUE_T4_GROUP_3_FAX = 3
    const val COMPRESSION_VALUE_T6_GROUP_4_FAX = 4
    const val COMPRESSION_VALUE_LZW = 5
    const val COMPRESSION_VALUE_JPEG_OLD_STYLE = 6
    const val COMPRESSION_VALUE_JPEG = 7
    const val COMPRESSION_VALUE_ADOBE_DEFLATE = 8
    const val COMPRESSION_VALUE_JBIG_B_AND_W = 9
    const val COMPRESSION_VALUE_JBIG_COLOR = 10
    const val COMPRESSION_VALUE_NEXT = 32766
    const val COMPRESSION_VALUE_EPSON_ERF_COMPRESSED = 32769
    const val COMPRESSION_VALUE_CCIRLEW = 32771
    const val COMPRESSION_VALUE_PACK_BITS = 32773
    const val COMPRESSION_VALUE_THUNDERSCAN = 32809
    const val COMPRESSION_VALUE_IT8CTPAD = 32895
    const val COMPRESSION_VALUE_IT8LW = 32896
    const val COMPRESSION_VALUE_IT8MP = 32897
    const val COMPRESSION_VALUE_IT8BL = 32898
    const val COMPRESSION_VALUE_PIXAR_FILM = 32908
    const val COMPRESSION_VALUE_PIXAR_LOG = 32909
    const val COMPRESSION_VALUE_DEFLATE = 32946
    const val COMPRESSION_VALUE_DCS = 32947
    const val COMPRESSION_VALUE_JBIG = 34661
    const val COMPRESSION_VALUE_SGILOG = 34676
    const val COMPRESSION_VALUE_SGILOG_24 = 34677
    const val COMPRESSION_VALUE_JPEG_2000 = 34712
    const val COMPRESSION_VALUE_NIKON_NEF_COMPRESSED = 34713
    const val COMPRESSION_VALUE_KODAK_DCR_COMPRESSED = 65000
    const val COMPRESSION_VALUE_PENTAX_PEF_COMPRESSED = 65535

    val TIFF_TAG_PHOTOMETRIC_INTERPRETATION = TagInfoShort(
        "PhotometricInterpretation", 0x106,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val PHOTOMETRIC_INTERPRETATION_VALUE_WHITE_IS_ZERO = 0
    const val PHOTOMETRIC_INTERPRETATION_VALUE_BLACK_IS_ZERO = 1
    const val PHOTOMETRIC_INTERPRETATION_VALUE_RGB = 2
    const val PHOTOMETRIC_INTERPRETATION_VALUE_RGB_PALETTE = 3
    const val PHOTOMETRIC_INTERPRETATION_VALUE_TRANSPARENCY_MASK = 4
    const val PHOTOMETRIC_INTERPRETATION_VALUE_CMYK = 5
    const val PHOTOMETRIC_INTERPRETATION_VALUE_YCB_CR = 6
    const val PHOTOMETRIC_INTERPRETATION_VALUE_CIELAB = 8
    const val PHOTOMETRIC_INTERPRETATION_VALUE_ICCLAB = 9
    const val PHOTOMETRIC_INTERPRETATION_VALUE_ITULAB = 10
    const val PHOTOMETRIC_INTERPRETATION_VALUE_COLOR_FILTER_ARRAY = 32803
    const val PHOTOMETRIC_INTERPRETATION_VALUE_PIXAR_LOG_L = 32844
    const val PHOTOMETRIC_INTERPRETATION_VALUE_PIXAR_LOG_LUV = 32845
    const val PHOTOMETRIC_INTERPRETATION_VALUE_LINEAR_RAW = 34892

    val TIFF_TAG_THRESHHOLDING = TagInfoShort(
        "Threshholding", 0x107,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val THRESHOLDING_VALUE_NO_DITHERING_OR_HALFTONING = 1
    const val THRESHOLDING_VALUE_ORDERED_DITHER_OR_HALFTONE = 2
    const val THRESHOLDING_VALUE_RANDOMIZED_DITHER = 3

    val TIFF_TAG_CELL_WIDTH = TagInfoShort(
        "CellWidth", 0x108,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_CELL_LENGTH = TagInfoShort(
        "CellLength", 0x109,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_FILL_ORDER = TagInfoShort(
        "FillOrder", 0x10A,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val FILL_ORDER_VALUE_NORMAL = 1
    const val FILL_ORDER_VALUE_REVERSED = 2

    val TIFF_TAG_DOCUMENT_NAME = TagInfoAscii(
        "DocumentName", 0x10D, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_IMAGE_DESCRIPTION = TagInfoAscii(
        "ImageDescription", 0x10E, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_MAKE = TagInfoAscii(
        "Make", 0x10F, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_MODEL = TagInfoAscii(
        "Model", 0x110, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_STRIP_OFFSETS = TagInfoShortOrLong(
        "StripOffsets", 0x111, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT, true
    )

    val TIFF_TAG_ORIENTATION = TagInfoShort(
        "Orientation", 0x112,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val ORIENTATION_VALUE_HORIZONTAL_NORMAL = 1
    const val ORIENTATION_VALUE_MIRROR_HORIZONTAL = 2
    const val ORIENTATION_VALUE_ROTATE_180 = 3
    const val ORIENTATION_VALUE_MIRROR_VERTICAL = 4
    const val ORIENTATION_VALUE_MIRROR_HORIZONTAL_AND_ROTATE_270_CW = 5
    const val ORIENTATION_VALUE_ROTATE_90_CW = 6
    const val ORIENTATION_VALUE_MIRROR_HORIZONTAL_AND_ROTATE_90_CW = 7
    const val ORIENTATION_VALUE_ROTATE_270_CW = 8

    val TIFF_TAG_SAMPLES_PER_PIXEL = TagInfoShort(
        "SamplesPerPixel", 0x115,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_ROWS_PER_STRIP = TagInfoShortOrLong(
        "RowsPerStrip", 0x116, 1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_STRIP_BYTE_COUNTS = TagInfoShortOrLong(
        "StripByteCounts", 0x117, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_MIN_SAMPLE_VALUE = TagInfoShorts(
        "MinSampleValue", 0x118, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_MAX_SAMPLE_VALUE = TagInfoShorts(
        "MaxSampleValue", 0x119, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_XRESOLUTION = TagInfoRational(
        "XResolution", 0x11A,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_YRESOLUTION = TagInfoRational(
        "YResolution", 0x11B,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_PLANAR_CONFIGURATION = TagInfoShort(
        "PlanarConfiguration", 0x11C,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val PLANAR_CONFIGURATION_VALUE_CHUNKY = 1
    const val PLANAR_CONFIGURATION_VALUE_PLANAR = 2

    val TIFF_TAG_PAGE_NAME = TagInfoAscii(
        "PageName", 0x11D, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_XPOSITION = TagInfoRationals(
        "XPosition", 0x11E, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_YPOSITION = TagInfoRationals(
        "YPosition", 0x11F, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_FREE_OFFSETS = TagInfoLongs(
        "FreeOffsets", 0x120, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_FREE_BYTE_COUNTS = TagInfoLongs(
        "FreeByteCounts", 0x121, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_GRAY_RESPONSE_UNIT = TagInfoShort(
        "GrayResponseUnit", 0x122,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val GRAY_RESPONSE_UNIT_VALUE_0_1 = 1
    const val GRAY_RESPONSE_UNIT_VALUE_0_01 = 2
    const val GRAY_RESPONSE_UNIT_VALUE_0_001 = 3
    const val GRAY_RESPONSE_UNIT_VALUE_0_0001 = 4
    const val GRAY_RESPONSE_UNIT_VALUE_0_00001 = 5

    val TIFF_TAG_GRAY_RESPONSE_CURVE = TagInfoShorts(
        "GrayResponseCurve", 0x123, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_T4_OPTIONS = TagInfoLong(
        "T4Options", 0x124,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_T6_OPTIONS = TagInfoLong(
        "T6Options", 0x125,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_RESOLUTION_UNIT = TagInfoShort(
        "ResolutionUnit", 0x128,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val RESOLUTION_UNIT_VALUE_NONE = 1
    const val RESOLUTION_UNIT_VALUE_INCHES = 2
    const val RESOLUTION_UNIT_VALUE_CM = 3

    val TIFF_TAG_PAGE_NUMBER = TagInfoShorts(
        "PageNumber", 0x129, 2,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_TRANSFER_FUNCTION = TagInfoShorts(
        "TransferFunction", 0x12D, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_SOFTWARE = TagInfoAscii(
        "Software", 0x131, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_DATE_TIME = TagInfoAscii(
        "DateTime", 0x132, 20,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_ARTIST = TagInfoAscii(
        "Artist", 0x13B, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_HOST_COMPUTER = TagInfoAscii(
        "HostComputer", 0x13C, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_PREDICTOR = TagInfoShort(
        "Predictor", 0x13D,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val PREDICTOR_VALUE_NONE = 1
    const val PREDICTOR_VALUE_HORIZONTAL_DIFFERENCING = 2
    const val PREDICTOR_VALUE_FLOATING_POINT_DIFFERENCING = 3

    val TIFF_TAG_WHITE_POINT = TagInfoRationals(
        "WhitePoint", 0x13E, 2,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_PRIMARY_CHROMATICITIES = TagInfoRationals(
        "PrimaryChromaticities", 0x13F, 6,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_COLOR_MAP = TagInfoShorts(
        "ColorMap", 0x140, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_HALFTONE_HINTS = TagInfoShorts(
        "HalftoneHints", 0x141, 2,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_TILE_WIDTH = TagInfoShortOrLong(
        "TileWidth", 0x142, 1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_TILE_LENGTH = TagInfoShortOrLong(
        "TileLength", 0x143, 1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_TILE_OFFSETS = TagInfoLongs(
        "TileOffsets", 0x144, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT, true
    )

    val TIFF_TAG_TILE_BYTE_COUNTS = TagInfoShortOrLong(
        "TileByteCounts", 0x145, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_INK_SET = TagInfoShort(
        "InkSet", 0x14C,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val INK_SET_VALUE_CMYK = 1
    const val INK_SET_VALUE_NOT_CMYK = 2

    val TIFF_TAG_INK_NAMES = TagInfoAscii(
        "InkNames", 0x14D, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_NUMBER_OF_INKS = TagInfoShort(
        "NumberOfInks", 0x14E,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_DOT_RANGE = TagInfoByteOrShort(
        "DotRange", 0x150, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_TARGET_PRINTER = TagInfoAscii(
        "TargetPrinter", 0x151, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_EXTRA_SAMPLES = TagInfoShorts(
        "ExtraSamples", 0x152, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val EXTRA_SAMPLE_ASSOCIATED_ALPHA = 1
    const val EXTRA_SAMPLE_UNASSOCIATED_ALPHA = 2

    val TIFF_TAG_SAMPLE_FORMAT = TagInfoShorts(
        "SampleFormat", 0x153, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val SAMPLE_FORMAT_VALUE_UNSIGNED_INTEGER = 1
    const val SAMPLE_FORMAT_VALUE_TWOS_COMPLEMENT_SIGNED_INTEGER = 2
    const val SAMPLE_FORMAT_VALUE_IEEE_FLOATING_POINT = 3
    const val SAMPLE_FORMAT_VALUE_UNDEFINED = 4
    const val SAMPLE_FORMAT_VALUE_COMPLEX_INTEGER = 5
    const val SAMPLE_FORMAT_VALUE_IEEE_COMPLEX_FLOAT = 6

    val TIFF_TAG_SMIN_SAMPLE_VALUE = TagInfoAny(
        "SMinSampleValue", 0x154, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_SMAX_SAMPLE_VALUE = TagInfoAny(
        "SMaxSampleValue", 0x155, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_TRANSFER_RANGE = TagInfoShorts(
        "TransferRange", 0x156, 6,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_PROC = TagInfoShort(
        "JPEGProc", 0x200,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val JPEGPROC_VALUE_BASELINE = 1
    const val JPEGPROC_VALUE_LOSSLESS = 14

    val TIFF_TAG_JPEG_INTERCHANGE_FORMAT = TagInfoLong(
        "JPEGInterchangeFormat", 0x201,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT, true
    )

    val TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = TagInfoLong(
        "JPEGInterchangeFormatLength", 0x202,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_RESTART_INTERVAL = TagInfoShort(
        "JPEGRestartInterval", 0x203,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_LOSSLESS_PREDICTORS = TagInfoShorts(
        "JPEGLosslessPredictors", 0x205, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_POINT_TRANSFORMS = TagInfoShorts(
        "JPEGPointTransforms", 0x206, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_QTABLES = TagInfoLongs(
        "JPEGQTables", 0x207, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_DCTABLES = TagInfoLongs(
        "JPEGDCTables", 0x208, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_JPEG_ACTABLES = TagInfoLongs(
        "JPEGACTables", 0x209, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_YCBCR_COEFFICIENTS = TagInfoRationals(
        "YCbCrCoefficients", 0x211, 3,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_YCBCR_SUB_SAMPLING = TagInfoShorts(
        "YCbCrSubSampling", 0x212, 2,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_YCBCR_POSITIONING = TagInfoShort(
        "YCbCrPositioning", 0x213,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    const val YCB_CR_POSITIONING_VALUE_CENTERED = 1
    const val YCB_CR_POSITIONING_VALUE_CO_SITED = 2

    val TIFF_TAG_REFERENCE_BLACK_WHITE = TagInfoLongs(
        "ReferenceBlackWhite", 0x214, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_COPYRIGHT = TagInfoAscii(
        "Copyright", 0x8298, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_XMP = TagInfoBytes(
        "XMP", 0x2BC, -1,
        TiffDirectoryType.Companion.TIFF_DIRECTORY_ROOT
    )

    val TIFF_TAG_UNKNOWN = TagInfoUnknowns(
        "Unknown", -1, TagInfo.LENGTH_UNKNOWN,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val ALL_TIFF_TAGS = listOf(
        TIFF_TAG_NEW_SUBFILE_TYPE, TIFF_TAG_SUBFILE_TYPE,
        TIFF_TAG_IMAGE_WIDTH, TIFF_TAG_IMAGE_LENGTH,
        TIFF_TAG_BITS_PER_SAMPLE, TIFF_TAG_COMPRESSION,
        TIFF_TAG_PHOTOMETRIC_INTERPRETATION, TIFF_TAG_THRESHHOLDING,
        TIFF_TAG_CELL_WIDTH, TIFF_TAG_CELL_LENGTH, TIFF_TAG_FILL_ORDER,
        TIFF_TAG_DOCUMENT_NAME, TIFF_TAG_IMAGE_DESCRIPTION, TIFF_TAG_MAKE,
        TIFF_TAG_MODEL, TIFF_TAG_STRIP_OFFSETS, TIFF_TAG_ORIENTATION,
        TIFF_TAG_SAMPLES_PER_PIXEL, TIFF_TAG_ROWS_PER_STRIP,
        TIFF_TAG_STRIP_BYTE_COUNTS, TIFF_TAG_MIN_SAMPLE_VALUE,
        TIFF_TAG_MAX_SAMPLE_VALUE, TIFF_TAG_XRESOLUTION,
        TIFF_TAG_YRESOLUTION, TIFF_TAG_PLANAR_CONFIGURATION,
        TIFF_TAG_PAGE_NAME, TIFF_TAG_XPOSITION, TIFF_TAG_YPOSITION,
        TIFF_TAG_FREE_OFFSETS, TIFF_TAG_FREE_BYTE_COUNTS,
        TIFF_TAG_GRAY_RESPONSE_UNIT, TIFF_TAG_GRAY_RESPONSE_CURVE,
        TIFF_TAG_T4_OPTIONS, TIFF_TAG_T6_OPTIONS, TIFF_TAG_RESOLUTION_UNIT,
        TIFF_TAG_PAGE_NUMBER, TIFF_TAG_TRANSFER_FUNCTION,
        TIFF_TAG_SOFTWARE, TIFF_TAG_DATE_TIME, TIFF_TAG_ARTIST,
        TIFF_TAG_HOST_COMPUTER, TIFF_TAG_PREDICTOR, TIFF_TAG_WHITE_POINT,
        TIFF_TAG_PRIMARY_CHROMATICITIES, TIFF_TAG_COLOR_MAP,
        TIFF_TAG_HALFTONE_HINTS, TIFF_TAG_TILE_WIDTH, TIFF_TAG_TILE_LENGTH,
        TIFF_TAG_TILE_OFFSETS, TIFF_TAG_TILE_BYTE_COUNTS, TIFF_TAG_INK_SET,
        TIFF_TAG_INK_NAMES, TIFF_TAG_NUMBER_OF_INKS, TIFF_TAG_DOT_RANGE,
        TIFF_TAG_TARGET_PRINTER, TIFF_TAG_EXTRA_SAMPLES,
        TIFF_TAG_SAMPLE_FORMAT, TIFF_TAG_SMIN_SAMPLE_VALUE,
        TIFF_TAG_SMAX_SAMPLE_VALUE, TIFF_TAG_TRANSFER_RANGE,
        TIFF_TAG_JPEG_PROC, TIFF_TAG_JPEG_INTERCHANGE_FORMAT,
        TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH,
        TIFF_TAG_JPEG_RESTART_INTERVAL, TIFF_TAG_JPEG_LOSSLESS_PREDICTORS,
        TIFF_TAG_JPEG_POINT_TRANSFORMS, TIFF_TAG_JPEG_QTABLES,
        TIFF_TAG_JPEG_DCTABLES, TIFF_TAG_JPEG_ACTABLES,
        TIFF_TAG_YCBCR_COEFFICIENTS, TIFF_TAG_YCBCR_SUB_SAMPLING,
        TIFF_TAG_YCBCR_POSITIONING, TIFF_TAG_REFERENCE_BLACK_WHITE,
        TIFF_TAG_COPYRIGHT,
        TIFF_TAG_XMP
    )
}
