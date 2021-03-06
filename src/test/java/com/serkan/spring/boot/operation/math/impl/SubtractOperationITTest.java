/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.serkan.spring.boot.AbstractITTest;
import com.serkan.spring.boot.operation.Operation;

public class SubtractOperationITTest extends AbstractITTest {
    @Autowired
    @Qualifier("subtractOperation")
    private Operation<BigDecimal> subtractOperation;

    @Test
    public void testSubtractOperation() {
        assertEquals(BigDecimal.valueOf(3), subtractOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2))));
    }

    @Test
    public void testSubtractZero() {
        assertEquals(BigDecimal.valueOf(5), subtractOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.ZERO)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractOneArgument() {
        subtractOperation.calculate(Arrays.asList(BigDecimal.valueOf(5)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractThreeArguments() {
        subtractOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(7)));
    }
}
