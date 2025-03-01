package org.example.services;

import java.util.List;
import java.util.UUID;

/**
 * @param <T>
 *
 * generic service that's going to be used by other services for basic operations
 */

public interface BaseService<T> {

    public T add(T object);

    public T findById(UUID id);

    public List<T> findAll();

    public UUID deleteById(UUID id);
}
