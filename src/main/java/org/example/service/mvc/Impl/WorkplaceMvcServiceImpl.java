package org.example.service.mvc.Impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Workplace;
import org.example.mapper.WorkplaceMapper;
import org.example.repository.WorkplaceRepo;
import org.example.service.mvc.CrudMvcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WorkplaceMvcServiceImpl implements CrudMvcService<Workplace> {

    private final WorkplaceRepo workplaceRepo;
    private final WorkplaceMapper workplaceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Workplace> list() {
        return workplaceRepo.findAll();
    }

    @Override
    @Transactional
    public Workplace create() {
        return new Workplace();
    }

    @Override
    @Transactional(readOnly = true)
    public Workplace getById(Long id) {
        return workplaceRepo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void save(Long id, Workplace item) {
        Workplace workplaceFromDB;
        if (Objects.isNull(id))
            workplaceFromDB = new Workplace();
        else
            workplaceFromDB = getById(id);
        workplaceMapper.merge(workplaceFromDB, item);
        workplaceRepo.save(workplaceFromDB);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        workplaceRepo.deleteById(id);
    }
}
