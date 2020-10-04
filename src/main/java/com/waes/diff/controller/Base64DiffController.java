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
package com.waes.diff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.waes.diff.entity.Base64Document;
import com.waes.diff.enums.Base64DocumentSide;
import com.waes.diff.exception.ResourceNotFoundException;
import com.waes.diff.model.Base64Data;
import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.service.Base64DocumentDiffService;
import com.waes.diff.util.Base64Util;
import com.waes.diff.util.Constants;

/**
 * The Class Base64DiffController.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@RestController()
@RequestMapping("/v1/diff")
public class Base64DiffController {

    /** The logger. */
    private static final Logger LOG = LoggerFactory.getLogger(Base64DiffController.class);

    /** The base 64 document service. */
    @Autowired
    private Base64DocumentDiffService base64DocumentService;

    /**
     * end-point to compare the left and right side of base64 encoded data
     * corresponding to Base64Document entity @see
     * com.waes.diff.entity.Base64Document. This end-point retrives the
     * Base64Document by {id} from database and then compares them. Based on the
     * comparison the {@link String} message is returned along with the offsets and
     * length.
     * 
     * @see com.waes.diff.entity.Base64Document
     *
     * @param id the id of Base64Document entity.
     * @return the diffs are returned in the form of Base64DiffResponse @see
     *         com.waes.diff.model.Base64DiffResponse, the {Base64DiffResponse} is
     *         the wrapper for the JSON response returnd the the client. It contains
     *         the {@link String} message and list of
     *         OffsetLength @see{com.waes.diff.model.OffsetLength}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Base64DiffResponse> getDiffs(@PathVariable Long id) {
        LOG.trace("Entering getDiffs(id={})", id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        try {
            Base64DiffResponse base64DiffResponse = base64DocumentService.compareBase64Data(id);
            return new ResponseEntity<Base64DiffResponse>(base64DiffResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResourceNotFoundException(Constants.DIFFS_ARE_NOT_FOUND_WITH_ID + id);
        }
    }

    /**
     * end-point which will store the data stream for specific {id} and and specific
     * {side} of the diff comparison. This end-point accepts JSON base64 encoded
     * binary data"
     * 
     * 
     * Example body content (in JSON format):
     * {"data":"dmFsaWQgYmFzZTY0IGRhdGEgY29udGVudA=="}
     *
     * @param id   the id of the object created to compare binary data. Only
     *             {@link Long} value is expected.
     * @param data the base64 encoded data
     * @return JSON data containing the status code and the message about the
     *         inserted data
     * @see com.waes.diff.entity.Base64Document
     * @throws Exception the exception
     */
    @PostMapping("/{id}/left")
    public ResponseEntity<Base64Document> createLeftBase64Document(@PathVariable Long id, @RequestBody Base64Data data)
            throws Exception {
        LOG.trace("Entering createLeftBase64Document(id={}, data={})", id, data);

        Base64Document base64Document = null;

        if (id == null || data == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if (base64DocumentService.validate(id, data.getData())) {
            
            Base64Util.decodeBase64Data(data);
            base64Document = base64DocumentService.save(id, data.getData(), Base64DocumentSide.LEFT);
            return new ResponseEntity<Base64Document>(base64Document, HttpStatus.CREATED);
        }
        return new ResponseEntity<Base64Document>(base64Document, HttpStatus.BAD_REQUEST);

    }

    /**
     * end-point which will store the data stream for specific {id} and and specific
     * {side} of the diff comparison. This end-point accepts JSON base64 encoded
     * binary data"
     * 
     * Example body content (in JSON format):
     * {"data":"dmFsaWQgYmFzZTY0IGRhdGEgY29udGVudA=="}
     *
     * @param id   the id of the object created to compare binary data. Only
     *             {@link Long} value is expected.
     * @param data the base64 encoded data
     * @return JSON data containing the status code and the message about the
     *         inserted data
     * @see com.waes.diff.entity.Base64Document
     * @throws Exception the exception
     */
    @PostMapping("/{id}/right")
    public ResponseEntity<Base64Document> createRightBase64Document(@PathVariable Long id, @RequestBody Base64Data data)
            throws Exception {
        LOG.trace("Entering createRightBase64Document(id={}, data={})", id, data);

        Base64Document base64Document = null;

        if (id == null || data == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        if (base64DocumentService.validate(id, data.getData())) {
            Base64Util.decodeBase64Data(data);
            base64Document = base64DocumentService.save(id, data.getData(), Base64DocumentSide.RIGHT);
            return new ResponseEntity<Base64Document>(base64Document, HttpStatus.CREATED);
        }
        return new ResponseEntity<Base64Document>(base64Document, HttpStatus.BAD_REQUEST);

    }

}
