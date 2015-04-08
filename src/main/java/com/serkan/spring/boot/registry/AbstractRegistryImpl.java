/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public abstract class AbstractRegistryImpl<K, E extends RegistryElement<K>> implements Registry<K, E>, ApplicationListener<ContextClosedEvent> {
    private final Map<K, E> elements = new HashMap<>();

    @Override
    public void registerElement(final E element) {
        elements.put(element.getKey(), element);
    }

    @Override
    public E getElement(final K key) {
        return elements.get(key);
    }

    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
        elements.clear();
    }
}
