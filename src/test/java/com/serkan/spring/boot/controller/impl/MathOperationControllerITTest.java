/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.serkan.spring.boot.AbstractITTest;

public class MathOperationControllerITTest extends AbstractITTest {
    @Autowired
    private MathOperationController controller;

    @Test
    public void testAdd() {
        assertEquals(BigDecimal.ONE, controller.operation("add", Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE)));
    }

    @Test
    public void testSubtract() {
        assertEquals(BigDecimal.valueOf(-1), controller.operation("subtract", Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE)));
    }

    @Test
    public void testDivide() {
        assertEquals(BigDecimal.valueOf(4), controller.operation("divide", Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2))));
    }

    @Test
    public void testMultiply() {
        assertEquals(BigDecimal.valueOf(16), controller.operation("multiply", Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2))));
    }

    @Test
    public void testAverage() {
        assertEquals(BigDecimal.valueOf(5d), controller.operation("average", Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        controller.operation("invalid", Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2)));
    }
}
