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
package com.waes.diff.base64.components.comparator;

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
import com.waes.diff.base64.components.comparator.IBase64DataComparator;
import com.waes.diff.model.Base64DiffResponse;
import com.waes.diff.repository.Base64DocumentRepository;
import com.waes.diff.util.Constants;

/**
 * The Class Base64DataComparatorTest.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Base64DataComparatorTest {

    /** The base 64 data validator. */
    @Autowired
    private IBase64DataComparator iBase64DataComparator;

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
     * Diff no data found.
     *
     * @throws Exception the exception
     */
    @Test
    public void diffNoDataFound() throws Exception {
        Mockito.doReturn(null).when(repository).findById(Mockito.eq(2L));
        Base64DiffResponse base64DiffResponse = iBase64DataComparator.compareBase64Data(2L);
        Assert.assertThat(base64DiffResponse.getMessage(), Matchers.is(Constants.NO_DATA_FOUND));
    }

}
