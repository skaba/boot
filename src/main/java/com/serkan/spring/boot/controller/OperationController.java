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

public abstract class OperationController<T> {

    private static Logger LOGGER = LoggerFactory.getLogger(OperationController.class);

    private final OperationServiceRegistry<T> registry;

    public OperationController(final OperationServiceRegistry<T> registry) {
        this.registry = registry;
    }

    public T operation(final List<T> elements, final String operatorName) {
        Operation<T> service = registry.getElement(operatorName);
        Assert.notNull(service, "Unknown operator: " + operatorName);
        LOGGER.debug("{} {} elements", service.getKey(), elements.size());
        return service.calculate(elements);
    }
}
