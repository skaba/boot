/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.math.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;

/**
 * Registry for decimal operations
 */
@Component
public class MathOperationServiceRegistry extends OperationServiceRegistry<BigDecimal> {
}
