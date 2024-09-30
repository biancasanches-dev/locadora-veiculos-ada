package com.locadora.dataFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudRepositoryImpl<T> implements CrudRepository<T> {
    protected final List<T> store = new ArrayList<>();

    @Override
    public T save(T entity) {
        store.add(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return store;
    }

    @Override
    public void delete(T entity) {
        store.remove(entity);
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.empty();
    }
}
