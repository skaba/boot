/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class HelloControllerMvcTest extends AbstractMvcTest<HelloController> {

    @Test
    public void testHello() throws Exception {
        getMockMvc().perform(get("/hello").param("name", "Serkan")).andExpect(status().isOk()).andExpect(content().string("Hello Serkan")).andExpect(content().contentType(MediaType.TEXT_PLAIN));
    }
}
