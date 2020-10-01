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
package com.waes.diff.service.impl;

import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waes.diff.base64.components.persist.IBase64DocumentPersister;
import com.waes.diff.base64.components.validator.IBase64DataValidator;
import com.waes.diff.base64.components.validator.IBase64Validator;
import com.waes.diff.entity.Base64Document;
import com.waes.diff.enums.Base64DocumentSide;
import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.service.Base64DocumentDiffService;

/**
 * The Class Base64DocumentDiffServiceImpl.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@Service
public class Base64DocumentDiffServiceImpl implements Base64DocumentDiffService {

    /** The i base 64 validator. */
    @Autowired
    private IBase64Validator iBase64Validator;

    @Autowired
    private IBase64DataValidator iBase64DataValidator;

    /** The i base 64 document persister. */
    @Autowired
    private IBase64DocumentPersister iBase64DocumentPersister;

    /**
     * Save.
     *
     * @param id   the id
     * @param data the data
     * @param side the side
     * @return the base 64 document
     * @throws Exception the exception
     * @see com.waes.diff.service.Base64DocumentDiffService#save(java.lang.Long,
     *      java.lang.String, com.waes.diff.enums.Base64DocumentSide)
     */
    @Override
    public Base64Document save(Long id, String data, Base64DocumentSide side) throws Exception {
        return iBase64DocumentPersister.save(id, data, side);
    }

    /**
     * Validate.
     *
     * @param id   the id
     * @param data the data
     * @return true, if successful
     * @throws ValidationException the validation exception
     * @see com.waes.diff.service.Base64DocumentDiffService#validate(java.lang.Long,
     *      java.lang.String)
     */
    @Override
    public boolean validate(Long id, String data) throws ValidationException {
        return iBase64Validator.validate(id, data);
    }

    /**
     * Validate base 64 data.
     *
     * @param id the id
     * @return the base 64 diff response
     * @see com.waes.diff.service.Base64DocumentDiffService#validateBase64Data(java.lang.Long)
     */
    @Override
    public Base64DiffResponse validateBase64Data(Long id) {
        return iBase64DataValidator.validateBase64Data(id);
    }

}
