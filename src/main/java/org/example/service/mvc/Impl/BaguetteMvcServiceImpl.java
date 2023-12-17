package org.example.service.mvc.Impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Baguette;
import org.example.mapper.BaguetteMapper;
import org.example.repository.BaguetteRepo;
import org.example.service.mvc.CrudMvcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BaguetteMvcServiceImpl implements CrudMvcService<Baguette> {

    private final BaguetteRepo baguetteRepo;
    private final BaguetteMapper baguetteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Baguette> list() {
        return baguetteRepo.findAll();
    }

    @Override
    @Transactional
    public Baguette create() {
        return new Baguette();
    }

    @Override
    @Transactional(readOnly = true)
    public Baguette getById(Long id) {
        return baguetteRepo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void save(Long id, Baguette item) {
        Baguette baguetteFromDB;
        if (Objects.isNull(id))
            baguetteFromDB = new Baguette();
        else
            baguetteFromDB = getById(id);
        baguetteMapper.merge(baguetteFromDB, item);
        baguetteRepo.save(baguetteFromDB);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        baguetteRepo.deleteById(id);
    }
}
