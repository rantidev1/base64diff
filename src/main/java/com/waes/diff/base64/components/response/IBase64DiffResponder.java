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
     * Write response.
     *
     * @param message          the message
     * @param offsetLengthList the offset length list
     * @return the base 64 diff response
     */
    Base64DiffResponse writeResponse(String message, List<OffsetLength> offsetLengthList);
}
