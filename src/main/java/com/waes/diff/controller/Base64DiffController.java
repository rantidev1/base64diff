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
import com.waes.diff.enums.Base64DocumentSide;
import com.waes.diff.exception.ResourceNotFoundException;
import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.model.Base64Data;
import com.waes.diff.entity.Base64Document;
import com.waes.diff.service.Base64DocumentDiffService;

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
     * Gets the diffs.
     *
     * @param id the id
     * @return the diffs
     */
    @GetMapping("/{id}")
    public ResponseEntity<Base64DiffResponse> getDiffs(@PathVariable Long id) {
        LOG.trace("Entering getDiffs(id={})", id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        try {
            Base64DiffResponse base64DiffResponse = base64DocumentService.validateBase64Data(id);
            return new ResponseEntity<Base64DiffResponse>(base64DiffResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResourceNotFoundException("diffs are not found with id " + id);
        }
    }

    /**
     * Creates the left base 64 document.
     *
     * @param id   the id
     * @param data the data
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/{id}/left")
    public ResponseEntity<Base64Document> createLeftBase64Document(@PathVariable Long id, @RequestBody Base64Data data)
            throws Exception {
        LOG.trace("Entering createLeftBase64Document(id={}, data={})", id, data);
        Base64Document base64Document = base64DocumentService.save(id, data.getData(), Base64DocumentSide.LEFT);
        return new ResponseEntity<Base64Document>(base64Document, HttpStatus.CREATED);

    }

    /**
     * Creates the right base 64 document.
     *
     * @param id   the id
     * @param data the data
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/{id}/right")
    public ResponseEntity<Base64Document> createRightBase64Document(@PathVariable Long id, @RequestBody Base64Data data)
            throws Exception {
        LOG.trace("Entering createRightBase64Document(id={}, data={})", id, data);
        Base64Document base64Document = base64DocumentService.save(id, data.getData(), Base64DocumentSide.RIGHT);
        return new ResponseEntity<Base64Document>(base64Document, HttpStatus.CREATED);

    }

}
