package org.example.repositories;

import java.util.List;

public interface GenericRepository <T> {

    public T add(T object);
    public T update(T object);
    public T delete(T object);
    public List<T> getAll();
}
