/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.serkan.spring.boot.BootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
public class TextOperationControllerITTest {
    @Autowired
    private TextOperationController controller;

    @Test
    public void testConcat() {
        assertEquals("foobar", controller.operation(Arrays.asList("foo", "bar"), "concat"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        controller.operation(Arrays.asList("foo", "bar"), "invalid");
    }
}
