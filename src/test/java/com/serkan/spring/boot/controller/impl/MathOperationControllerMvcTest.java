/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;

public class MathOperationControllerMvcTest extends AbstractMvcTest<MathOperationController> {

    @Test
    public void testAdd() throws Exception {
        getMockMvc().perform(get("/math/add").param("n", "0", "1")).andExpect(status().isOk()).andExpect(content().string("1")).andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    @Test
    public void testSubtract() throws Exception {
        getMockMvc().perform(get("/math/subtract").param("n", "0", "1")).andExpect(status().isOk()).andExpect(content().string("-1")).andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    @Test
    public void testDivide() throws Exception {
        getMockMvc().perform(get("/math/divide").param("n", "8", "2")).andExpect(status().isOk()).andExpect(content().string("4")).andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    @Test
    public void testMultiply() throws Exception {
        getMockMvc().perform(get("/math/multiply").param("n", "8", "2")).andExpect(status().isOk()).andExpect(content().string("16")).andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    @Test
    public void testAverage() throws Exception {
        getMockMvc().perform(get("/math/average").param("n", "8", "2")).andExpect(status().isOk()).andExpect(content().string("5.0")).andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    @Test
    @Ignore
    public void testInvalidOperator() throws Exception {
        getMockMvc().perform(get("/math/invalid").param("n", "8", "2")).andExpect(status().is4xxClientError());
    }
}
