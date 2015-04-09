/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.math.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operator.MathOperator;

/**
 * Decimal addition operator
 */
@Component
public class Add extends MathOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Add.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal apply(final BigDecimal t, final BigDecimal u) {
        LOGGER.debug("apply({},{})", t, u);
        return t.add(u);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getIdentity() {
        LOGGER.debug("getIdentity()");
        return BigDecimal.ZERO;
    }

}
