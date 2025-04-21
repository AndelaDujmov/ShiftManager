package org.example.services;

import java.util.List;
import java.util.UUID;

/**
 * @param <T, R>
 *
 * generic service that's going to be used by other services for basic operations
 */

public interface BaseService<T, R> {

    public T add(R object);

    public T findById(UUID id);

    public List<T> findAll();

    public T deleteById(UUID id);

    public T update(R object, UUID id);
}
