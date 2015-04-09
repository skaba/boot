/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

/**
 * Class defining contract for operations that can take only two arguments
 */
public abstract class BinaryMathOperation extends Operation<BigDecimal> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryMathOperation.class);

    public BinaryMathOperation(final String name, final OperationServiceRegistry<BigDecimal> registry) {
        super(name, registry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal calculate(final List<BigDecimal> input) {
        LOGGER.debug("{}: calculate({},{})", getName(), input);
        if (input.size() != 2) {
            throw new IllegalArgumentException(getName() + " needs exactly two operators");
        }
        return binaryOperation(input.get(0), input.get(1));
    }

    /**
     * Calculate the value of the binary operation
     * 
     * @param left Left hand side value
     * @param right Right hand side value
     * @return Result
     */
    protected abstract BigDecimal binaryOperation(BigDecimal left, BigDecimal right);

}
