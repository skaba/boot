/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation;

import java.util.List;

import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;
import com.serkan.spring.boot.registry.RegistryElement;

public abstract class Operation<T> implements RegistryElement<String> {

    private final String name;

    public Operation(final String name, final OperationServiceRegistry<T> registry) {
        this.name = name;
        registry.registerElement(this);
    }

    public abstract T calculate(final List<T> input);

    @Override
    public String getKey() {
        return name;
    }

    public String getName() {
        return name;
    }

}
