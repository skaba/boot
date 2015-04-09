/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operator.Operator;

/**
 * Operation that reduces the list by an operator
 * 
 * @param <T> Type of the input and output values
 */
public class ReduceOperation<T> extends Operation<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReduceOperation.class);
    private final Operator<T> operator;

    public ReduceOperation(final String name, final Operator<T> operator, final OperationServiceRegistry<T> registry) {
        super(name, registry);
        this.operator = operator;
    }

    @Override
    public T calculate(final List<T> input) {
        LOGGER.debug("{}: calculate({})", getName(), input);
        return input.parallelStream().reduce(operator.getIdentity(), operator);
    }

}
