package org.example.service.mvc;

import java.util.List;

public interface CrudMvcService<T> {
    List<T> list();
    T create();
    T getById(Long id);
    void save(Long id, T item);
    void delete(Long id);
}
