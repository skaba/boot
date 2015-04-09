/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

/**
 * 
 * Registry of elements
 * 
 * @param <K> Key type
 * @param <E> Element type
 */
public interface Registry<K, E extends RegistryElement<K>> {
    /**
     * Register an element
     * 
     * @param element Element to register
     */
    void registerElement(E element);

    /**
     * Lookup element by key
     * 
     * @param key Key
     * @return Element or <code>null</code> if not found
     */
    E getElement(K key);
}
