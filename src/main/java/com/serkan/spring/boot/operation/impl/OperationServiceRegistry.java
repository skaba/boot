/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation.impl;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.registry.AbstractRegistryImpl;

public abstract class OperationServiceRegistry<T> extends AbstractRegistryImpl<String, Operation<T>> {

}
