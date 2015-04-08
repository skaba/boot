/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.text.impl;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

@Component
public class TextOperationServiceRegistry extends OperationServiceRegistry<String> {
    @PreDestroy
    @Override
    public void deregisterAllElements() {
        super.deregisterAllElements();
    }
}
