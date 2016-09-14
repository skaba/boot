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

public class AddOperationITTest extends AbstractITTest {
    @Autowired
    @Qualifier("addOperation")
    private Operation<BigDecimal> addOperation;

    @Test
    public void testAddOperation() {
        assertEquals(BigDecimal.valueOf(7), addOperation.calculate(Arrays.asList(BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.ZERO)));
    }
}
