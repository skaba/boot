/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.text.impl;

import static org.junit.Assert.assertEquals;

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
public class ConcatOperationITTest {
    @Autowired
    @Qualifier("concatOperation")
    private Operation<String> concatOperation;

    @Test
    public void testConcatOperation() {
        assertEquals("foobarbaz", concatOperation.calculate(Arrays.asList("foo", "bar", "baz")));
    }
}
