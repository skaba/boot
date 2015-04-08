/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

@Component
public class MathOperationServiceRegistry extends OperationServiceRegistry<BigDecimal> {
    @PreDestroy
    @Override
    public void deregisterAllElements() {
        super.deregisterAllElements();
    }
}
