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
package com.waes.diff.service;

import javax.xml.bind.ValidationException;

import com.waes.diff.entity.Base64Document;
import com.waes.diff.enums.Base64DocumentSide;
import com.waes.diff.model.Base64DiffResponse;

/**
 * The Interface Base64DocumentDiffService.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public interface Base64DocumentDiffService {

    /**
     * Save.
     *
     * @param id   the id
     * @param data the data
     * @param side the side
     * @return the base 64 document
     * @throws Exception the exception
     */
    Base64Document save(Long id, String data, Base64DocumentSide side) throws Exception;

    /**
     * Validate.
     *
     * @param id   the id
     * @param data the data
     * @return true, if successful
     * @throws ValidationException the validation exception
     */
    boolean validate(Long id, String data) throws ValidationException;

    /**
     * Validate base 64 data.
     *
     * @param id the id
     * @return the base 64 diff response
     */
    Base64DiffResponse validateBase64Data(Long id);

}
