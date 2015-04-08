/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator.text.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConcatTest {
    @Test
    public void testApply() {
        Concat concat = new Concat();
        assertEquals("foobar", concat.apply("foo", "bar"));
    }
}
