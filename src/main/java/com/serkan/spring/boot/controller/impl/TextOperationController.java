/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serkan.spring.boot.controller.OperationController;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

@RestController
public class TextOperationController extends OperationController<String> {

    @Autowired
    public TextOperationController(final OperationServiceRegistry<String> registry) {
        super(registry);
    }

    @Override
    @RequestMapping(value = "/text/{operator}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String operation(@RequestParam(value = "w", required = false, defaultValue = "")
    final List<String> words, @PathVariable("operator")
    final String operatorName) {
        return super.operation(words, operatorName);
    }
}
