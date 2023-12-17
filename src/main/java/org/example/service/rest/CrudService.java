package org.example.service.rest;

import java.util.List;

public interface CrudService<D> {
        List<D> getAll();
        D getById(Long id);
        void delete(Long id);
        D create(D dto);
        D update(D dto, Long id);
}
