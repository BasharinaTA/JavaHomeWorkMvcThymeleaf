package com.homework_mvc_thymeleaf.services;

import java.util.List;

public interface DataService<E> {
    List<E> getAll();

    E get(Integer id);

    E save(E e);

    void delete(Integer id);
}
