/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

@Component
public class AverageOperation extends Operation<BigDecimal> {

    @Autowired
    public AverageOperation(final OperationServiceRegistry<BigDecimal> registry) {
        super("average", registry);
    }

    @Override
    public BigDecimal calculate(final List<BigDecimal> input) {
        return BigDecimal.valueOf(input.parallelStream().mapToDouble(BigDecimal::doubleValue).average().orElse(0));
    }
}
