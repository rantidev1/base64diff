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

import java.util.List;

/**
 * The Class Base64DiffResponse.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public class Base64DiffResponse {

    /** The message. */
    private String message;

    /** The offset length list. */
    private List<OffsetLength> offsetLengthList;

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the offset length list.
     *
     * @return the offsetLengthList
     */
    public List<OffsetLength> getOffsetLengthList() {
        return offsetLengthList;
    }

    /**
     * Sets the offset length list.
     *
     * @param offsetLengthList the offsetLengthList to set
     */
    public void setOffsetLengthList(List<OffsetLength> offsetLengthList) {
        this.offsetLengthList = offsetLengthList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Base64DiffResponse [message=" + message + ", offsetLengthList=" + offsetLengthList + "]";
    }

}
