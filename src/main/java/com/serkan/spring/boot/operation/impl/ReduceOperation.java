/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.impl;

import java.util.List;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operator.Operator;

public class ReduceOperation<T> extends Operation<T> {

    private final Operator<T> operator;

    public ReduceOperation(final String name, final Operator<T> operator, final OperationServiceRegistry<T> registry) {
        super(name, registry);
        this.operator = operator;
    }

    @Override
    public T calculate(final List<T> input) {
        return input.parallelStream().reduce(operator.getIdentity(), operator);
    }

}
