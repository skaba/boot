/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.serkan.spring.boot.BootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractMvcTest {

    protected static MediaType TEXT_PLAIN = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(APPLICATION_JSON.getType(), APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private EmbeddedWebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @LocalServerPort
    private String portNumber;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).alwaysDo(print()).build();
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    protected void expectMethodNotSupported(final String url, final String parameterName, final String... parameterValues) throws Exception {
        mockMvc.perform(put(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(patch(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(delete(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        // TODO: Fix following
        // mockMvc.perform(options(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
        // mockMvc.perform(head(url).param(parameterName, parameterValues)).andExpect(status().isMethodNotAllowed());
    }

    protected void getAndExpectStatus(final String path, final String parameterName, final HttpStatus expected, final String... parameterValues) {
        final Map<String, List<String>> urlVariables = new HashMap<>();
        final List<String> parameterValuesList = Arrays.asList(parameterValues);
        urlVariables.put(parameterName, parameterValuesList);

        final ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + portNumber + path, String.class, urlVariables);
        assertEquals(expected, response.getStatusCode());
        // Below doesn't work
        // getMockMvc().perform(get(path).param(parameterName, parameterValues)).andExpect(status().is(expected.value()));
    }
}
