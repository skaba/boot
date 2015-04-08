/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.math.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class MultiplyTest {

    @Test
    public void testApply() {
        Multiply multiply = new Multiply();
        assertEquals(BigDecimal.valueOf(6), multiply.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(3)));
    }

    @Test
    public void testMultiplyByZero() {
        Multiply multiply = new Multiply();
        assertEquals(BigDecimal.ZERO, multiply.apply(BigDecimal.valueOf(2), BigDecimal.ZERO));
    }

    @Test
    public void testMultiplyByOne() {
        Multiply multiply = new Multiply();
        assertEquals(BigDecimal.valueOf(2), multiply.apply(BigDecimal.valueOf(2), BigDecimal.ONE));
    }
}
