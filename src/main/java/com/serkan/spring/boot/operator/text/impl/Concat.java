/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.text.impl;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operator.Operator;

/**
 * String concatanation operator
 */
@Component
public class Concat implements Operator<String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String apply(final String t, final String u) {
        return t + u;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIdentity() {
        return "";
    }

}
