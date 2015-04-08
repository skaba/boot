/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serkan.spring.boot.controller.OperationController;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

@RestController
public class MathOperationController extends OperationController<BigDecimal> {

    @Autowired
    public MathOperationController(final OperationServiceRegistry<BigDecimal> registry) {
        super(registry);
    }

    @Override
    @RequestMapping("/math/{operator}")
    public BigDecimal operation(@RequestParam(value = "n", required = false, defaultValue = "")
    final List<BigDecimal> numbers, @PathVariable("operator")
    final String operatorName) {
        return super.operation(numbers, operatorName);
    }
}
