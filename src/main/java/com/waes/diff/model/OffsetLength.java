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
package com.waes.diff.model;

/**
 * The Class OffsetLength.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public class OffsetLength {

    /** The offset. */
    private int offset;

    /** The length. */
    private int length;

    /**
     * Gets the offset.
     *
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     *
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length.
     *
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OffsetLength [offset=" + offset + ", length=" + length + "]";
    }

}
