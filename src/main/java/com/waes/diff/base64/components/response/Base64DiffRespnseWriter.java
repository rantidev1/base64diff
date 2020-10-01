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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.model.OffsetLength;

/**
 * The Class Base64DiffRespnseWriter.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */

@Component
public class Base64DiffRespnseWriter implements IBase64DiffResponder {

    /** The logger. */
    private static final Logger LOG = LoggerFactory.getLogger(Base64DiffRespnseWriter.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.waes.diff.base64.components.response.IBase64DiffResponder#writeResponse(
     * java.lang.String, java.util.List)
     */
    @Override
    public Base64DiffResponse writeResponse(String message, List<OffsetLength> offsetLengthList) {

        LOG.trace("Entering writeResponse(message={}, offsetLengthList={})", message, offsetLengthList);

        var base64DiffResponse = new Base64DiffResponse();
        base64DiffResponse.setMessage(message);
        base64DiffResponse.setOffsetLengthList(offsetLengthList);
        return base64DiffResponse;
    }

}
