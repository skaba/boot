/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.math.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operator.MathOperator;

@Component
public class Add extends MathOperator {

    @Override
    public BigDecimal apply(final BigDecimal t, final BigDecimal u) {
        return t.add(u);
    }

    @Override
    public BigDecimal getIdentity() {
        return BigDecimal.ZERO;
    }

}
