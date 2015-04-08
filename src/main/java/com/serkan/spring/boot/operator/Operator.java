/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operator;

import java.util.function.BinaryOperator;

public interface Operator<T> extends BinaryOperator<T> {
    T getIdentity();
}
