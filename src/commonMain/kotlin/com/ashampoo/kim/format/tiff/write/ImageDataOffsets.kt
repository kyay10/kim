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
package com.ashampoo.kim.format.tiff.write

import com.ashampoo.kim.format.tiff.TiffElement.DataElement

class ImageDataOffsets(
    imageData: Array<DataElement>,
    val imageDataOffsets: IntArray,
    val imageDataOffsetsField: TiffOutputField
) {

    val outputItems: Array<TiffOutputItem>

    init {

        val finalOutputItems = arrayOfNulls<TiffOutputItem>(imageData.size)

        repeat(finalOutputItems.size) { i ->
            finalOutputItems[i] = TiffOutputItem.Value(imageData[i].bytes)
        }

        this.outputItems = finalOutputItems as Array<TiffOutputItem>
    }
}
