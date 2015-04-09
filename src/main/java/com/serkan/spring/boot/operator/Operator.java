/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator;

import java.util.function.BinaryOperator;

/**
 * Operator used in operations
 * 
 * @param <T>
 */
public interface Operator<T> extends BinaryOperator<T> {
    /**
     * Identity value for the operator
     * 
     * @return Identity value
     */
    T getIdentity();
}
