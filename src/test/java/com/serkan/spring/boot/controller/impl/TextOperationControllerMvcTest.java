/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class TextOperationControllerMvcTest extends AbstractMvcTest {
    @Test
    public void testConcat() throws Exception {
        getMockMvc().perform(get("/text/concat").param("w", "foo", "bar")).andExpect(status().isOk()).andExpect(content().string("foobar")).andExpect(content().contentType(TEXT_PLAIN));
    }

    @Test
    @Ignore
    public void testInvalidOperator() throws Exception {
        getAndExpectStatus("/text/foo", "w", HttpStatus.INTERNAL_SERVER_ERROR, "foo", "bar");
    }

    @Test
    public void testUnacceptableResponse() throws Exception {
        getMockMvc().perform(get("/text/concat").param("w", "foo", "bar").accept(APPLICATION_JSON_UTF8)).andExpect(status().isNotAcceptable()).andExpect(content().string(""));
    }

    @Test
    public void testUnSupportedethods() throws Exception {
        expectMethodNotSupported("/text/concat", "w", "foo", "bar");
    }
}
