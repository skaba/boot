/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

/**
 * Generic controller for operations
 * 
 * @param <T> Type of the input and output values
 */
public abstract class OperationController<T> {

    /** Logger **/
    private static Logger LOGGER = LoggerFactory.getLogger(OperationController.class);

    /** Operation registry to lookup operations from **/
    private final OperationServiceRegistry<T> registry;

    public OperationController(final OperationServiceRegistry<T> registry) {
        this.registry = registry;
    }

    /**
     * Generic operation method to be used by subclasses
     * 
     * @param elements Input values
     * @param operatorName Operator
     * @return Result of the operation
     */
    protected T operation(final String operatorName, final List<T> elements) {
        Operation<T> operation = registry.getElement(operatorName);
        Assert.notNull(operation, "Unknown operation: " + operatorName);
        LOGGER.debug("{} {} elements", operation.getKey(), elements.size());
        return operation.calculate(elements);
    }
}
