/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.serkan.spring.boot.BootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
public class MathOperationControllerITTest {
    @Autowired
    private MathOperationController controller;

    @Test
    public void testAdd() {
        assertEquals(BigDecimal.ONE, controller.operation(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE), "add"));
    }

    @Test
    public void testSubtract() {
        assertEquals(BigDecimal.valueOf(-1), controller.operation(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE), "subtract"));
    }

    @Test
    public void testDivide() {
        assertEquals(BigDecimal.valueOf(4), controller.operation(Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2)), "divide"));
    }

    @Test
    public void testMultiply() {
        assertEquals(BigDecimal.valueOf(16), controller.operation(Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2)), "multiply"));
    }

    @Test
    public void testAverage() {
        assertEquals(BigDecimal.valueOf(5d), controller.operation(Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2)), "average"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        controller.operation(Arrays.asList(BigDecimal.valueOf(8), BigDecimal.valueOf(2)), "invalid");
    }
}
