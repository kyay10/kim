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

object IptcConstants {
    const val IPTC_NON_EXTENDED_RECORD_MAXIMUM_SIZE = 32_767
    const val IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_INFO = 0x03e8
    const val IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO = 0x03e9
    const val IMAGE_RESOURCE_BLOCK_XML_DATA = 0x03ea
    const val IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE = 0x03eb
    const val IMAGE_RESOURCE_BLOCK_RESOLUTION_INFO = 0x03ed
    const val IMAGE_RESOURCE_BLOCK_ALPHA_CHANNELS_NAMES = 0x03ee
    const val IMAGE_RESOURCE_BLOCK_DISPLAY_INFO = 0x03ef
    const val IMAGE_RESOURCE_BLOCK_PSTRING_CAPTION = 0x03f0
    const val IMAGE_RESOURCE_BLOCK_BORDER_INFORMATION = 0x03f1
    const val IMAGE_RESOURCE_BLOCK_BACKGROUND_COLOR = 0x03f2
    const val IMAGE_RESOURCE_BLOCK_PRINT_FLAGS = 0x03f3
    const val IMAGE_RESOURCE_BLOCK_BW_HALFTONING_INFO = 0x03f4
    const val IMAGE_RESOURCE_BLOCK_COLOR_HALFTONING_INFO = 0x03f5
    const val IMAGE_RESOURCE_BLOCK_DUOTONE_HALFTONING_INFO = 0x03f6
    const val IMAGE_RESOURCE_BLOCK_BW_TRANSFER_FUNC = 0x03f7
    const val IMAGE_RESOURCE_BLOCK_COLOR_TRANSFER_FUNCS = 0x03f8
    const val IMAGE_RESOURCE_BLOCK_DUOTONE_TRANSFER_FUNCS = 0x03f9
    const val IMAGE_RESOURCE_BLOCK_DUOTONE_IMAGE_INFO = 0x03fa
    const val IMAGE_RESOURCE_BLOCK_EFFECTIVE_BW = 0x03fb
    const val IMAGE_RESOURCE_BLOCK_OBSOLETE_PHOTOSHOP_TAG1 = 0x03fc
    const val IMAGE_RESOURCE_BLOCK_EPS_OPTIONS = 0x03fd
    const val IMAGE_RESOURCE_BLOCK_QUICK_MASK_INFO = 0x03fe
    const val IMAGE_RESOURCE_BLOCK_OBSOLETE_PHOTOSHOP_TAG2 = 0x03ff
    const val IMAGE_RESOURCE_BLOCK_LAYER_STATE_INFO = 0x0400
    const val IMAGE_RESOURCE_BLOCK_WORKING_PATH = 0x0401
    const val IMAGE_RESOURCE_BLOCK_LAYERS_GROUP_INFO = 0x0402
    const val IMAGE_RESOURCE_BLOCK_OBSOLETE_PHOTOSHOP_TAG3 = 0x0403
    const val IMAGE_RESOURCE_BLOCK_IPTC_DATA = 0x0404
    const val IMAGE_RESOURCE_BLOCK_RAW_IMAGE_MODE = 0x0405
    const val IMAGE_RESOURCE_BLOCK_JPEG_QUALITY = 0x0406
    const val IMAGE_RESOURCE_BLOCK_GRID_GUIDES_INFO = 0x0408
    const val IMAGE_RESOURCE_BLOCK_PHOTOSHOP_BGR_THUMBNAIL = 0x0409
    const val IMAGE_RESOURCE_BLOCK_COPYRIGHT_FLAG = 0x040a
    const val IMAGE_RESOURCE_BLOCK_URL = 0x040b
    const val IMAGE_RESOURCE_BLOCK_PHOTOSHOP_THUMBNAIL = 0x040c
    const val IMAGE_RESOURCE_BLOCK_GLOBAL_ANGLE = 0x040d
    const val IMAGE_RESOURCE_BLOCK_COLOR_SAMPLERS_RESOURCE = 0x040e
    const val IMAGE_RESOURCE_BLOCK_ICC_PROFILE = 0x040f
    const val IMAGE_RESOURCE_BLOCK_WATERMARK = 0x0410
    const val IMAGE_RESOURCE_BLOCK_ICC_UNTAGGED = 0x0411
    const val IMAGE_RESOURCE_BLOCK_EFFECTS_VISIBLE = 0x0412
    const val IMAGE_RESOURCE_BLOCK_SPOT_HALFTONE = 0x0413
    const val IMAGE_RESOURCE_BLOCK_IDS_BASE_VALUE = 0x0414
    const val IMAGE_RESOURCE_BLOCK_UNICODE_ALPHA_NAMES = 0x0415
    const val IMAGE_RESOURCE_BLOCK_INDEXED_COLOUR_TABLE_COUNT = 0x0416
    const val IMAGE_RESOURCE_BLOCK_TRANSPARENT_INDEX = 0x0417
    const val IMAGE_RESOURCE_BLOCK_GLOBAL_ALTITUDE = 0x0419
    const val IMAGE_RESOURCE_BLOCK_SLICES = 0x041a
    const val IMAGE_RESOURCE_BLOCK_WORKFLOW_URL = 0x041b
    const val IMAGE_RESOURCE_BLOCK_JUMP_TO_XPEP = 0x041c
    const val IMAGE_RESOURCE_BLOCK_ALPHA_IDENTIFIERS = 0x041d
    const val IMAGE_RESOURCE_BLOCK_URL_LIST = 0x041e
    const val IMAGE_RESOURCE_BLOCK_VERSION_INFO = 0x0421
    const val IMAGE_RESOURCE_BLOCK_EXIFINFO = 0x0422
    const val IMAGE_RESOURCE_BLOCK_EXIF_INFO2 = 0x0423
    const val IMAGE_RESOURCE_BLOCK_XMP = 0x0424
    const val IMAGE_RESOURCE_BLOCK_CAPTION_DIGEST = 0x0425
    const val IMAGE_RESOURCE_BLOCK_PRINT_SCALE = 0x0426
    const val IMAGE_RESOURCE_BLOCK_PIXEL_ASPECT_RATIO = 0x0428
    const val IMAGE_RESOURCE_BLOCK_LAYER_COMPS = 0x0429
    const val IMAGE_RESOURCE_BLOCK_ALTERNATE_DUOTONE_COLORS = 0x042a
    const val IMAGE_RESOURCE_BLOCK_ALTERNATE_SPOT_COLORS = 0x042b
    const val IMAGE_RESOURCE_BLOCK_CLIPPING_PATH_NAME = 0x0bb7
    const val IMAGE_RESOURCE_BLOCK_PRINT_FLAGS_INFO = 0x2710
    const val IPTC_RECORD_TAG_MARKER = 0x1c
    const val IPTC_ENVELOPE_RECORD_NUMBER = 0x01
    const val IPTC_APPLICATION_2_RECORD_NUMBER = 0x02
}
