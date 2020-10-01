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
package com.waes.diff.base64.components.validator;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class Base64Validator.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */

@Component
public class Base64Validator implements IBase64Validator {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(Base64Validator.class);

    /**
     * @see com.waes.diff.base64.components.validator.IBase64Validator#validate(java.lang.Long,
     *      java.lang.String)
     */
    @Override
    public boolean validate(Long id, String data) throws ValidationException {
        var isValid = true;
        LOG.trace("Entering validate(id={}, data={})", id, data);

        LOG.debug("Validating request for id '{}'", id);
        if (StringUtils.isEmpty(data)) {
            LOG.warn("data is blank or null");
            isValid = false;
        }
        LOG.trace("Leaving validate(id, data)={}", isValid);
        return isValid;
    }

}

