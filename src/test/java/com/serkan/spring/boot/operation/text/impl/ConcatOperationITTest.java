/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.text.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.serkan.spring.boot.AbstractITTest;
import com.serkan.spring.boot.operation.Operation;

public class ConcatOperationITTest extends AbstractITTest {
    @Autowired
    @Qualifier("concatOperation")
    private Operation<String> concatOperation;

    @Test
    public void testConcatOperation() {
        assertEquals("foobarbaz", concatOperation.calculate(Arrays.asList("foo", "bar", "baz")));
    }
}
