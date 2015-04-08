/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.serkan.spring.boot.BootApplication;
import com.serkan.spring.boot.operation.Operation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
public class MultiplyOperationITTest {
    @Autowired
    @Qualifier("multiplyOperation")
    private Operation<BigDecimal> multiplyOperation;

    @Test
    public void testMultiplyOperation() {
        assertEquals(BigDecimal.valueOf(30), multiplyOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(3))));
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(BigDecimal.ZERO, multiplyOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.ZERO)));
    }

    @Test
    public void testMultiplyByOne() {
        assertEquals(BigDecimal.valueOf(10), multiplyOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.ONE)));
    }
}
