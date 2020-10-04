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

import com.waes.diff.entity.Base64Document;
import com.waes.diff.enums.Base64DocumentSide;

/**
 * The Interface IBase64DocumentPersister.
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public interface IBase64DocumentPersister {

    /**
     * Saves the base64 encoded data with side (either left/right) in to the
     * database.
     *
     * @param id   the id
     * @param data the base64 encoded data
     * @param side the side of the base64 encoded document
     * @see com.waes.diff.enums.Base64DocumentSide
     * @return the Base64Document
     * @see com.waes.diff.entity.Base64Document
     * @throws Exception the exception
     */
    Base64Document save(Long id, String data, Base64DocumentSide side) throws Exception;

}
