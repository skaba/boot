/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.operation;

import java.util.List;

import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;
import com.serkan.spring.boot.registry.RegistryElement;

/**
 * Abstract class defining contract for operations.
 * 
 * @param <T> Input and output type of the operation
 */
public abstract class Operation<T> implements RegistryElement<String> {

    /** Name of the operation **/
    private final String name;

    public Operation(final String name, final OperationServiceRegistry<T> registry) {
        this.name = name;
        registry.registerElement(this);
    }

    /**
     * Calculate the result of the operation
     * 
     * @param input Input values
     * @return Result
     */
    public abstract T calculate(final List<T> input);

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     * Get operation name
     * 
     * @return Operation name
     */
    public String getName() {
        return name;
    }

}
