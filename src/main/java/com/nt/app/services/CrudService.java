package com.nt.app.services;

import java.util.List;

public interface CrudService<T> {

    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    void delete(Long id);

}
