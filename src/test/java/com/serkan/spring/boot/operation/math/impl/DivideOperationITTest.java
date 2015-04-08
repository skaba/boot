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
public class DivideOperationITTest {
    @Autowired
    @Qualifier("divideOperation")
    private Operation<BigDecimal> divideOperation;

    @Test
    public void testDivideOperation() {
        assertEquals(BigDecimal.valueOf(2.5), divideOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2))));
    }

    @Test
    public void testDivideByOne() {
        assertEquals(BigDecimal.valueOf(5), divideOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.ONE)));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        divideOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.ZERO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideOneArgument() {
        divideOperation.calculate(Arrays.asList(BigDecimal.valueOf(5)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideThreeArguments() {
        divideOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(7)));
    }
}
