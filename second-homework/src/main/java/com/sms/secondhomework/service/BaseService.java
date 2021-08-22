package com.sms.secondhomework.service;

import java.util.List;

public interface BaseService<T>{

    List<T> findAll();
    T findById(int id);
    T save (T object);
    T update(T object);
    void delete(T object);
    void deletebyId(int id);

}
