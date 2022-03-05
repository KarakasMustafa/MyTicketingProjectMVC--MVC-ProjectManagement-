package com.mustafa.services;

import com.mustafa.dto.RoleDTO;

import java.util.List;

public interface CrudService<T,ID> {

    List<T> findAll();
    T findByID(ID id);
    void delete(T object);
    void deleteByID(ID id);
    T save(T object);
    void update(T object);
}
