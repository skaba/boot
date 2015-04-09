/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serkan.spring.boot.controller.OperationController;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

/**
 * Controller for math operations
 */
@RestController
public class MathOperationController extends OperationController<BigDecimal> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MathOperationController.class);

    /**
     * Autowired constructor
     * 
     * @param registry Operation registry
     */
    @Autowired
    public MathOperationController(final OperationServiceRegistry<BigDecimal> registry) {
        super(registry);
    }

    /**
     * <code>/math/{operator}</code> binding. Runs math operations {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/math/{operator}", method = { GET, POST })
    public BigDecimal operation(@PathVariable("operator")
    final String operatorName, @RequestParam(value = "n", required = false, defaultValue = "")
    final List<BigDecimal> numbers) {
        LOGGER.debug("operation(\"{}\",{})", operatorName, numbers);
        return super.operation(operatorName, numbers);
    }
}
