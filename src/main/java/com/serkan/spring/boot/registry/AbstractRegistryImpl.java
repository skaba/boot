/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.serkan.spring.boot.registry;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Abstract implementation of {@link Registry} using {@link HashMap} as storage and deregistering elements when Spring context is closed.
 * 
 * @param <K> Type of the key of the registry elements
 * @param <E> Type of the registry elements
 */
public abstract class AbstractRegistryImpl<K, E extends RegistryElement<K>> implements Registry<K, E>, ApplicationListener<ContextClosedEvent> {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    /** Storage map **/
    private final Map<K, E> elements = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerElement(final E element) {
        LOGGER.debug("registerElement({})", element);
        elements.put(element.getKey(), element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getElement(final K key) {
        LOGGER.debug("getElement({})", key);
        return elements.get(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void onApplicationEvent(final ContextClosedEvent event) {
        LOGGER.debug("onApplicationEvent({})", event);
        elements.clear();
    }
}
