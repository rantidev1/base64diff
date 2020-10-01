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

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.waes.diff.entity.Base64Document;
import com.waes.diff.repository.Base64DocumentRepository;
import com.waes.diff.util.Constants;

/**
 * The Class Base64DiffControllerIntegrationTest.
 * 
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Base64DiffControllerIntegrationTest {

    /** The mvc. */
    @Autowired
    private MockMvc mvc;

    /** The repository. */
    @Autowired
    public Base64DocumentRepository repository;

    /** The web application context. */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(webApplicationContext).build();
        this.repository.deleteAll();
    }

    /**
     * Insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void insert() throws Exception {
        left();
        Thread.sleep(3000);
        right();
    }

    /**
     * Left.
     *
     * @throws Exception the exception
     */
    @SuppressWarnings("deprecation")
    private void left() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/v1/diff/1/left").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content("{\n" + "  \"data\": "
                        + "  \"d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI=\"" + "}"))
                .andExpect(status().isCreated()).andReturn();
        Base64Document base64Document = repository.findById(1L);
        Assert.assertThat(base64Document.getId(), Matchers.is(1L));
        Assert.assertThat(base64Document.getLeft(),
                Matchers.is("d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI="));
        Assert.assertThat(base64Document.getRight(), Matchers.isEmptyOrNullString());
    }

    /**
     * Right.
     *
     * @throws Exception the exception
     */
    private void right() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/v1/diff/1/right").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content("{\n" + "  \"data\": "
                        + "  \"d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI=\"" + "}"))
                .andExpect(status().isCreated()).andReturn();
        Base64Document base64Document = repository.findById(1L);
        Assert.assertThat(base64Document.getId(), Matchers.is(1L));
        Assert.assertThat(base64Document.getRight(),
                Matchers.is("d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI="));
        Assert.assertThat(base64Document.getLeft(),
                Matchers.is("d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI="));
    }

    /**
     * Equal.
     *
     * @throws Exception the exception
     */
    @Test
    public void equal() throws Exception {
        repository.save(new Base64Document(1l, "d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI=",
                "d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI="));
        mvc.perform(MockMvcRequestBuilders.get("/v1/diff/1").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "  \"data\": " + "  \"d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI==\""
                        + "}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.message", is(Constants.BASE64_DATA_ARE_EQUAL)))
                .andReturn();
    }

    /**
     * Different.
     *
     * @throws Exception the exception
     */
    @Test
    public void different() throws Exception {
        repository.save(new Base64Document(1l, "d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBkaWZmIGNvbnRyb2xsZXI=",
                "d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBiYXNlNjQgZGlmZiBjb250cm9sbGVy="));
        mvc.perform(MockMvcRequestBuilders.get("/v1/diff/1").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "  \"data\": "
                        + "  \"d3JpdGluZyBpbnRlZ3JhdGlvbiB0ZXN0IGZvciBiYXNlNjQgZGlmZiBjb250cm9sbGVy=\"" + "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is(Constants.BASE64_DATA_HAVE_NOT_SAME_SIZE))).andReturn();
    }

}
