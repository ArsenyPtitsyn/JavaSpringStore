package ru.geekbrains.hibernate.h2.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Dao<T> {
    T findById(Long id);
    List<T> findAll();
    T saveOrUpdate(T t);
    void deleteById(Long id);
}
