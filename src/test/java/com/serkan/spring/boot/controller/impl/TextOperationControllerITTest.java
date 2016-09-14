/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.serkan.spring.boot.AbstractITTest;

public class TextOperationControllerITTest extends AbstractITTest {
    @Autowired
    private TextOperationController controller;

    @Test
    public void testConcat() {
        assertEquals("foobar", controller.operation("concat", Arrays.asList("foo", "bar")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        controller.operation("invalid", Arrays.asList("foo", "bar"));
    }
}
