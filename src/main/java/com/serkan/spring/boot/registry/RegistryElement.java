/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

/**
 * Element That can be registered in a registry
 * 
 * @param <K> Key type
 */
public interface RegistryElement<K> {
    public K getKey();
}
