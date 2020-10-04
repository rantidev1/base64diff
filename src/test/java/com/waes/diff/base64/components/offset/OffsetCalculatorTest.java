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
package com.waes.diff.base64.components.offset;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.waes.diff.entity.Base64Document;

/**
 * The Class OffsetCalculatorTest.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OffsetCalculatorTest {

    /** The offset calculator. */
    @InjectMocks
    private OffsetCalculator offsetCalculator;


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
     * Calculate offsets not found test.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateOffsetsNotFoundTest() throws Exception {
        Base64Document base64Document = new Base64Document(1L, null, "anVzIGEgc2ltcGxlIHRlc3Q=");
        List<Integer> offsetList = offsetCalculator.calculateOffsets(base64Document);
        Assert.assertTrue(offsetList.isEmpty());
    }

    /**
     * Calculate offsets test.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateOffsetsTest() throws Exception {
        Base64Document base64Document = new Base64Document(3L, "anVzIGEgc2ltcGxlIHRlc3Q=", "anVzIGEgc2ltcGxlIHFxcXE=");

        List<Integer> offsetList = offsetCalculator.calculateOffsets(base64Document);
        Assert.assertTrue(offsetList.size() > 0);
    }

}
