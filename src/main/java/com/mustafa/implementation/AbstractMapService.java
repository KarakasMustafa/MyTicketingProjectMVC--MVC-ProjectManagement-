package com.mustafa.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T,ID> {
    private Map<ID,T> map = new HashMap<>();

    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

    T findById(ID id){
        return map.get(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void update(ID id,T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
        map.put(id,object);
    }

}
