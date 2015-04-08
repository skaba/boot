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
public class DivideOperation extends BinaryMathOperation {

    @Autowired
    public DivideOperation(final OperationServiceRegistry<BigDecimal> registry) {
        super("divide", registry);
    }

    @Override
    protected BigDecimal binaryOperation(final BigDecimal left, final BigDecimal right) {
        return left.divide(right);
    }

}
