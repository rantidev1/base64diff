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

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.waes.diff.entity.Base64Document;
import com.waes.diff.enums.Base64DocumentSide;
import com.waes.diff.repository.Base64DocumentRepository;

/**
 * The Class Base64DocumentPersisterTest.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Base64DocumentPersisterTest {

    /** The base 64 document persister. */
    @Autowired
    private Base64DocumentPersister base64DocumentPersister;

    /** The repository. */
    @Mock
    public Base64DocumentRepository repository;

    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Save left.
     *
     * @throws Exception the exception
     */
    @SuppressWarnings("deprecation")
    @Test
    public void saveLeft() throws Exception {
        Base64Document base64Document = new Base64Document(1L, null, "Left");
        Mockito.doReturn(base64Document).when(repository).findById(Mockito.eq(1L));
        Base64Document left = base64DocumentPersister.save(1L, "Left", Base64DocumentSide.LEFT);
        Assert.assertThat(left.getId(), Matchers.is(1L));
        Assert.assertThat(left.getLeft(), Matchers.is("Left"));
        Assert.assertThat(left.getRight(), Matchers.isEmptyOrNullString());
    }

}
