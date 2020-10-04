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
package com.waes.diff.base64.components.response;

import java.util.List;

import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.model.OffsetLength;

/**
 * The Interface IBase64DiffResponder.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public interface IBase64DiffResponder {

    /**
     * This is the convenience method which wraps the data namely message and
     * offsetLengthList in to the Base64DiffResponse.
     * 
     * @see com.waes.diff.model.Base64DiffResponse
     *
     * @param message the message which is returned after comparing the left and
     *                right side of the base64 encoded document.
     * @see com.waes.diff.entity.Base64Document
     * @param offsetLengthList the list of OffsetLength
     * @see com.waes.diff.model.OffsetLength
     * @return the Base64DiffResponse , which contains the String message based on
     *         the comparison of left and right side of the base64 encoded document.
     *         if the left and right side of the base64 encoded document are of
     *         equal size then offsetLengthList will have offsets at which left and
     *         right side differs along with the offset length.
     */
    Base64DiffResponse writeResponse(String message, List<OffsetLength> offsetLengthList);
}
