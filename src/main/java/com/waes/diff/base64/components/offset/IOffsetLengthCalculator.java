/*******************************************************************************
 * Copyright 2020 rantidev.singh1@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.waes.diff.base64.components.offset;

import java.util.List;

import com.waes.diff.model.OffsetLength;

/**
 * The Interface IOffsetLengthCalculator.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public interface IOffsetLengthCalculator {

    /**
     * Calculates the offset length based on the content of offsetArray. offsetArray
     * will have all the indexes at which the base64 encoded data (left and right
     * side) differs.
     * 
     * @param offsetArray offsetArray will have all the indexes at which the base64
     *                    encoded data (left and right side) differs. offsetArray will
     *                    also have the last element as the Integer "-1" to
     *                    demarcate the end of offsets in the array.
     * 
     * @return the list of OffsetLength
     * @see com.waes.diff.model.OffsetLength
     */
    List<OffsetLength> calculateOffsetLength(Integer[] offsetArray);

}
