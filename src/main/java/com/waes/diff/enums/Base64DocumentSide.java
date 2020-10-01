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
package com.waes.diff.enums;

/**
 * The Enum Base64DocumentSide.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public enum Base64DocumentSide {

    /** The left. */
    LEFT,
    /** The right. */
    RIGHT;

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        switch (this) {
        case LEFT:
            return "LEFT";
        case RIGHT:
            return "RIGHT";
        }
        throw new Error("An error occurred while trying to get the correct side.");
    }
}

