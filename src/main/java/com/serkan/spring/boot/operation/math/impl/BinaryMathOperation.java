/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;
import java.util.List;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

public abstract class BinaryMathOperation extends Operation<BigDecimal> {

    public BinaryMathOperation(final String name, final OperationServiceRegistry<BigDecimal> registry) {
        super(name, registry);
    }

    @Override
    public BigDecimal calculate(final List<BigDecimal> input) {
        if (input.size() != 2) {
            throw new IllegalArgumentException(getName() + " needs exactly two operators");
        }
        return binaryOperation(input.get(0), input.get(1));
    }

    protected abstract BigDecimal binaryOperation(BigDecimal left, BigDecimal right);

}
