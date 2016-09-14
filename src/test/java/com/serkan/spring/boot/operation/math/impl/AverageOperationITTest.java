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

public class AverageOperationITTest extends AbstractITTest {
    @Autowired
    @Qualifier("averageOperation")
    private Operation<BigDecimal> averageOperation;

    @Test
    public void testAverageOperation() {
        assertEquals(BigDecimal.valueOf(3d), averageOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(2))));
    }
}
