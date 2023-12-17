package org.example.service.mvc.Impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Cutter;
import org.example.mapper.CutterMapper;
import org.example.repository.CutterRepo;
import org.example.service.mvc.CrudMvcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CutterMvcServiceImpl implements CrudMvcService<Cutter> {

    private final CutterRepo cutterRepo;
    private final CutterMapper cutterMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Cutter> list() {
        return cutterRepo.findAll();
    }

    @Override
    @Transactional
    public Cutter create() {
        return new Cutter();
    }

    @Override
    @Transactional(readOnly = true)
    public Cutter getById(Long id) {
        return cutterRepo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void save(Long id, Cutter item) {
        Cutter baguetteFromDB;
        if (Objects.isNull(id))
            baguetteFromDB = new Cutter();
        else
            baguetteFromDB = getById(id);
        cutterMapper.merge(baguetteFromDB, item);
        cutterRepo.save(baguetteFromDB);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cutterRepo.deleteById(id);
    }
}
