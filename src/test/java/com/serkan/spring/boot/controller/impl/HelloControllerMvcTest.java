/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class HelloControllerMvcTest extends AbstractMvcTest {

    @Test
    public void testHello() throws Exception {
        getMockMvc().perform(get("/hello").param("name", "Serkan")).andExpect(status().isOk()).andExpect(content().string("Hello Serkan")).andExpect(content().contentType(TEXT_PLAIN));
    }

    @Test
    public void testHelloNoParameter() throws Exception {
        getMockMvc().perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("Hello Stranger")).andExpect(content().contentType(TEXT_PLAIN));
    }

    @Test
    public void testUnacceptableResponse() throws Exception {
        getMockMvc().perform(get("/hello").param("name", "Serkan").accept(APPLICATION_JSON_UTF8)).andExpect(status().isNotAcceptable()).andExpect(content().string(""));
    }

    @Test
    public void testUnSupportedethods() throws Exception {
        expectMethodNotSupported("/hello", "name", "serkan");
    }
}
