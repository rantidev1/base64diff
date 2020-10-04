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
package com.waes.diff.repository;

import org.springframework.data.repository.CrudRepository;
import com.waes.diff.entity.Base64Document;

/**
 * The Interface Base64DocumentRepository.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
public interface Base64DocumentRepository extends CrudRepository<Base64Document, Long> {

    /**
     * This method finds the
     * Base64Document @see{com.waes.diff.entity.Base64Document} by {id} .
     *
     * @param id the id
     * @return the instance of Base64Document for supplied {id}
     */
    Base64Document findById(long id);
}
