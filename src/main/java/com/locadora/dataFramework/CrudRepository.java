package com.locadora.dataFramework;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void delete(T entity);
}
