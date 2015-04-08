/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.math.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operator.MathOperator;

@Component
public class Multiply extends MathOperator {

    @Override
    public BigDecimal apply(final BigDecimal t, final BigDecimal u) {
        return t.multiply(u);
    }

    @Override
    public BigDecimal getIdentity() {
        return BigDecimal.ONE;
    }
}
