/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world controller
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * <code>/hello</code> binding
     * 
     * @param name Name of the person
     * @return Hello output
     */
    @RequestMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE, method = { GET, POST })
    public String hello(@RequestParam(required = false, defaultValue = "Stranger")
    final String name) {
        LOGGER.debug("hello({})", name);
        return "Hello " + name;
    }
}
