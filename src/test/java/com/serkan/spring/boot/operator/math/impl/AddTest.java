/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.math.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AddTest {

    @Test
    public void testApply() {
        Add add = new Add();
        assertEquals(BigDecimal.valueOf(5), add.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(3)));
    }

    @Test
    public void testAddZero() {
        Add add = new Add();
        assertEquals(BigDecimal.valueOf(5), add.apply(BigDecimal.valueOf(5), BigDecimal.ZERO));
    }
}
