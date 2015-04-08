/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

@Component
public class SubtractOperation extends BinaryMathOperation {

    @Autowired
    public SubtractOperation(final OperationServiceRegistry<BigDecimal> registry) {
        super("subtract", registry);
    }

    @Override
    protected BigDecimal binaryOperation(final BigDecimal left, final BigDecimal right) {
        return left.subtract(right);
    }

}
