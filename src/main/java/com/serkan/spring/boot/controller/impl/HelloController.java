/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world controller
 */
@RestController
public class HelloController {
    /**
     * <code>/hello</code> binding
     * 
     * @param name Name of the person
     * @return Hello output
     */
    @RequestMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(@RequestParam(required = false, defaultValue = "Stranger")
    final String name) {
        return "Hello " + name;
    }
}
