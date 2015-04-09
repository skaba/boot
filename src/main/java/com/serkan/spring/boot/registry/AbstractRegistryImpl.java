/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Abstract implementation of {@link Registry} using {@link HashMap} as storage and deregistering elements when Spring context is closed.
 * 
 * @param <K>
 * @param <E>
 */
public abstract class AbstractRegistryImpl<K, E extends RegistryElement<K>> implements Registry<K, E>, ApplicationListener<ContextClosedEvent> {
    /** Storage map **/
    private final Map<K, E> elements = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerElement(final E element) {
        elements.put(element.getKey(), element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getElement(final K key) {
        return elements.get(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
        elements.clear();
    }
}
