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
 * The Class Base64Data.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public class Base64Data {

    /**
     * Gets the data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /** The data. */
    private String data;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Base64Data [data=" + data + "]";
    }

}
