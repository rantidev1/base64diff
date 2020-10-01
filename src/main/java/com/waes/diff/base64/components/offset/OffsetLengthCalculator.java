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

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.waes.diff.model.OffsetLength;

/**
 * The Class OffsetLengthCalculator.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */

@Component
public class OffsetLengthCalculator implements IOffsetLengthCalculator {

    /** The logger. */
    private static final Logger LOG = LoggerFactory.getLogger(OffsetLengthCalculator.class);

    /**
     * Calculate offset length.
     *
     * @param offsetArray the offset array
     * @return the list
     * @see com.waes.diff.base64.components.offset.IOffsetLengthCalculator#calculateOffsetLength
     *      (java.lang.Integer[])
     */
    @Override
    public List<OffsetLength> calculateOffsetLength(Integer[] offsetArray) {

        LOG.trace("Entering calculateOffsets(offsetArray)");

        if (offsetArray == null || offsetArray.length == 0) {
            return null;
        }

        var lengthList = new ArrayList<Integer>();
        var offsetLengthList = new ArrayList<OffsetLength>();

        int diff = 0;

        for (int index = 0; index < offsetArray.length - 1; index++) {

            if (offsetArray[index + 1] == -1) { // reached at end of array
                diff = -1;

            } else {
                diff = offsetArray[index + 1] - offsetArray[index];
            }

            if (diff == 1) {
                lengthList.add(Integer.valueOf(index));

            } else {
                lengthList.add(Integer.valueOf(index));
                OffsetLength offsetLength = new OffsetLength();
                offsetLength.setOffset(offsetArray[lengthList.get(0)]);
                offsetLength.setLength(lengthList.size());
                offsetLengthList.add(offsetLength);
                lengthList.clear();
                continue;
            }

        }

        return offsetLengthList;
    }

}
