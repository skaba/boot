/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

public interface Registry<K, E extends RegistryElement<K>> {
    void registerElement(E element);

    E getElement(K key);
}
