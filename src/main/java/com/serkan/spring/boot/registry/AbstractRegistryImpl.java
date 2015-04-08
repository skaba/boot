/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRegistryImpl<K, E extends RegistryElement<K>> implements Registry<K, E> {
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
    public void deregisterAllElements() {
        elements.clear();
    }

}
