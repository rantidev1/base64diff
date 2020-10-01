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
package com.waes.diff.base64.components.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.diff.base64.components.validator.IBase64Validator;
import com.waes.diff.entity.Base64Document;
import com.waes.diff.enums.Base64DocumentSide;
import com.waes.diff.repository.Base64DocumentRepository;

/**
 * The Class Base64DocumentPersister.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */

@Component
public class Base64DocumentPersister implements IBase64DocumentPersister {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(Base64DocumentPersister.class);

    /** The base 64 document repository. */
    @Autowired
    private Base64DocumentRepository base64DocumentRepository;

    /** The i base 64 validator. */
    @Autowired
    private IBase64Validator iBase64Validator;

    /**
     * Save.
     *
     * @param id   the id
     * @param data the data
     * @param side the side
     * @return the base 64 document
     * @throws Exception the exception
     * @see com.waes.diff.base64.components.persist.IBase64DocumentPersister#save(java.lang.Long,
     *      java.lang.String, com.waes.diff.enums.Base64DocumentSide)
     */
    @Override
    public Base64Document save(Long id, String data, Base64DocumentSide side) throws Exception {

        LOG.trace("Entering calculateOffsets(id={}, data={}, side={})", id, data, side);

        Base64Document base64Document = null;
        if (iBase64Validator.validate(id, data)) {
            base64Document = base64DocumentRepository.findById(id).orElse(new Base64Document());
            base64Document.setId(id);

            if (Base64DocumentSide.LEFT.equals(side)) {
                base64Document.setLeft(data);
            } else if (Base64DocumentSide.RIGHT.equals(side)) {
                base64Document.setRight(data);
            } else {
                LOG.warn("Invalid side sent.");
            }
            base64Document = base64DocumentRepository.save(base64Document);
        }
        return base64Document;
    }

}
