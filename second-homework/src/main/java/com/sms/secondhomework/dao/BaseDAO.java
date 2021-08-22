package com.sms.secondhomework.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDAO <T> {
    //repository
    List<T> findAll();
    T findById(int id);
    T save (T object);
    T update(T object);
    void delete(T object);
    void deletebyId(int id);

}
