/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.serkan.spring.boot.BootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=8080" })
public abstract class AbstractMvcTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(APPLICATION_JSON.getType(), APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private EmbeddedWebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).alwaysDo(print()).build();
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    protected void expectMethodNotSupported(final String url, final String parameterName, final String... parameterValues) throws Exception {
        mockMvc.perform(put(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(patch(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(delete(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        // TODO: Figure out why options is always supported
        // mockMvc.perform(options(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(head(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
    }
}
