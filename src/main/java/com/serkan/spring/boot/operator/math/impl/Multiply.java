/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.math.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operator.MathOperator;

/**
 * Decimal multiplication operator
 */
@Component
public class Multiply extends MathOperator {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal apply(final BigDecimal t, final BigDecimal u) {
        return t.multiply(u);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getIdentity() {
        return BigDecimal.ONE;
    }
}
