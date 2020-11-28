package com.mustafa.services;

import java.util.List;

public interface CrudService<T,ID> {

   List<T> findAll();
   T save(T object);
   T findById(ID id);
   void delete(T object);
   void deleteById(ID id);
   void update(T object);




}
