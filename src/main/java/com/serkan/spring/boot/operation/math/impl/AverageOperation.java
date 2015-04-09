/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

/**
 * Average operation
 */
@Component
public class AverageOperation extends Operation<BigDecimal> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AverageOperation.class);

    /**
     * Autowired constructor
     * 
     * @param registry Operation registry
     */
    @Autowired
    public AverageOperation(final OperationServiceRegistry<BigDecimal> registry) {
        super("average", registry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal calculate(final List<BigDecimal> input) {
        LOGGER.debug("{}: calculate({},{})", getName(), input);
        return BigDecimal.valueOf(input.parallelStream().mapToDouble(BigDecimal::doubleValue).average().orElse(0));
    }
}
