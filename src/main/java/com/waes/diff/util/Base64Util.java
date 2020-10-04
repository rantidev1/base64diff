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
package com.waes.diff.util;

import java.util.Base64;

import com.waes.diff.exception.Base64Exception;
import com.waes.diff.model.Base64Data;

/**
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 *
 */

public class Base64Util {

    /**
     * Decode base 64 data.
     *
     * @param data the data
     * @throws Base64Exception the base64exception signals that the data is not a
     *                         Valid base64 encoded value
     */
    public static void decodeBase64Data(Base64Data data) {

        try {
            Base64.getDecoder().decode(data.getData());
        } catch (Exception ex) {
            throw new Base64Exception(Constants.NOT_VALID_BASE64_ENCODED_VALUE);
        }

    }

}
