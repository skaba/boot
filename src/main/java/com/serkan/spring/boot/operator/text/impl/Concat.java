/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.text.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operator.Operator;

/**
 * String concatanation operator
 */
@Component
public class Concat implements Operator<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Concat.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public String apply(final String t, final String u) {
        LOGGER.debug("apply(\"{}\",\"{}\")", t, u);
        return t + u;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIdentity() {
        LOGGER.debug("getIdentity()");
        return "";
    }

}
