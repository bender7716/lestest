package org.example.service.rest.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.baguette.BaguetteDto;
import org.example.entity.Baguette;
import org.example.mapper.BaguetteMapper;
import org.example.repository.BaguetteRepo;
import org.example.service.rest.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BaguetteRestServiceImpl implements CrudService<BaguetteDto> {

    private final BaguetteRepo baguetteRepo;
    private final BaguetteMapper baguetteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BaguetteDto> getAll() {
        List<Baguette> baguettes = baguetteRepo.findAll();
        return baguetteMapper.mapBaguetteListToBaguetteDtoList(baguettes);
    }

    @Override
    @Transactional(readOnly = true)
    public BaguetteDto getById(Long id) {
        Baguette baguette = baguetteRepo.findById(id).orElseThrow();
        return baguetteMapper.mapBaguetteToBaguetteDto(baguette);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        baguetteRepo.deleteById(id);
    }

    @Override
    @Transactional
    public BaguetteDto create(BaguetteDto dto) {
        Baguette baguette = baguetteMapper.mapBaguetteDtoToBaguette(dto);
        Baguette savedBaguette = baguetteRepo.save(baguette);
        return baguetteMapper.mapBaguetteToBaguetteDto(savedBaguette);
    }

    @Override
    @Transactional
    public BaguetteDto update(BaguetteDto dto, Long id) {
        Baguette oldBaguette = baguetteRepo.findById(id).orElseThrow();
        Baguette newBaguette = baguetteMapper.mapBaguetteDtoToBaguette(dto);
        baguetteMapper.merge(oldBaguette, newBaguette);
        Baguette savedBaguette = baguetteRepo.save(oldBaguette);
        return baguetteMapper.mapBaguetteToBaguetteDto(savedBaguette);
    }
}
