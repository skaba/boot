/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;

public class TextOperationControllerMvcTest extends AbstractMvcTest<TextOperationController> {
    @Test
    public void testConcat() throws Exception {
        getMockMvc().perform(get("/text/concat").param("w", "foo", "bar")).andExpect(status().isOk()).andExpect(content().string("foobar")).andExpect(content().contentType(TEXT_PLAIN));
    }

    @Test
    @Ignore
    public void testInvalidOperator() throws Exception {
        getMockMvc().perform(get("/text/invalid").param("w", "foo", "bar")).andExpect(status().is4xxClientError());
    }
}
