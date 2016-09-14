/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.controller.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.serkan.spring.boot.AbstractITTest;

public class HelloControllerITTest extends AbstractITTest {
    @Autowired
    private HelloController controller;

    @Test
    public void testHello() {
        assertEquals("Hello Serkan", controller.hello("Serkan"));
    }
}
