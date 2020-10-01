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

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import com.waes.diff.base64.components.offset.IOffsetCalculator;
import com.waes.diff.base64.components.offset.IOffsetLengthCalculator;
import com.waes.diff.base64.components.response.IBase64DiffResponder;
import com.waes.diff.entity.Base64Document;
import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.model.OffsetLength;
import com.waes.diff.repository.Base64DocumentRepository;
import com.waes.diff.util.Constants;

/**
 * The Class Base64DataValidator.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */

@Component
public class Base64DataValidator implements IBase64DataValidator {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(Base64DataValidator.class);

    /** The i offset length calculator. */
    @Autowired
    private IOffsetLengthCalculator iOffsetLengthCalculator;

    /** The i offset calculator. */
    @Autowired
    private IOffsetCalculator iOffsetCalculator;

    /** The i base 64 diff responder. */
    @Autowired
    private IBase64DiffResponder iBase64DiffResponder;

    /** The base 64 document repository. */
    @Autowired
    private Base64DocumentRepository base64DocumentRepository;

    /**
     * Validate base 64 data.
     *
     * @param id the id
     * @return the base 64 diff response
     * @see com.waes.diff.base64.components.validator.IBase64DataValidator#validateBase64Data(java.
     *      lang.Long)
     */
    @Override
    public Base64DiffResponse validateBase64Data(Long id) {
        LOG.trace("Entering validateBase64Data(id={})", id);

        LOG.debug("trying to find the document for id '{}'", id);
        var base64Document = base64DocumentRepository.findById(id).orElse(null);

        if (base64Document == null) {
            return iBase64DiffResponder.writeResponse(Constants.NO_DATA_FOUND, null);
        }

        LOG.debug("base64Document found. Checking the base64 data on both sides for id '{}'", id);
        if (!StringUtils.isNotBlank(base64Document.getLeft()) || !StringUtils.isNotBlank(base64Document.getRight())) {
            return iBase64DiffResponder.writeResponse(Constants.BASE64_DATA_MISSING, null);
        }

        byte[] bytesLeft = base64Document.getLeft().getBytes();
        byte[] bytesRight = base64Document.getRight().getBytes();

        boolean blnResult = Arrays.equals(bytesLeft, bytesRight);

        List<Integer> offsetList;

        if (blnResult) {
            return iBase64DiffResponder.writeResponse(Constants.BASE64_DATA_ARE_EQUAL, null);
        } else if (bytesLeft.length != bytesRight.length) {
            return iBase64DiffResponder.writeResponse(Constants.BASE64_DATA_HAVE_NOT_SAME_SIZE, null);
        } else {
            offsetList = iOffsetCalculator.calculateOffsets(base64Document);
        }

        offsetList.add(-1); // adding last element for demarcation.

        var offsetLengthList = iOffsetLengthCalculator
                .calculateOffsetLength(offsetList.stream().toArray(Integer[]::new));
        return iBase64DiffResponder.writeResponse(Constants.BASE64_DATA_HAVE_THE_SAME_SIZE, offsetLengthList);
    }

}

