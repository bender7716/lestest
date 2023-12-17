package org.example.service.rest.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.cutter.CutterDto;
import org.example.entity.Cutter;
import org.example.mapper.CutterMapper;
import org.example.repository.CutterRepo;
import org.example.service.rest.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CutterRestServiceImpl implements CrudService<CutterDto> {

    private final CutterRepo cutterRepo;
    private final CutterMapper cutterMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CutterDto> getAll() {
        List<Cutter> cutters = cutterRepo.findAll();
        return cutterMapper.mapCutterListToCutterDtoList(cutters);
    }

    @Override
    @Transactional(readOnly = true)
    public CutterDto getById(Long id) {
        Cutter cutter = cutterRepo.findById(id).orElseThrow();
        return cutterMapper.mapCutterToCutterDto(cutter);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cutterRepo.deleteById(id);
    }

    @Override
    @Transactional
    public CutterDto create(CutterDto dto) {
        Cutter cutter = cutterMapper.mapCutterDtoToCutter(dto);
        Cutter savedCutter = cutterRepo.save(cutter);
        return cutterMapper.mapCutterToCutterDto(savedCutter);
    }

    @Override
    @Transactional
    public CutterDto update(CutterDto dto, Long id) {
        Cutter oldCutter = cutterRepo.findById(id).orElseThrow();
        Cutter newCutter = cutterMapper.mapCutterDtoToCutter(dto);
        cutterMapper.merge(oldCutter, newCutter);
        Cutter savedCutter = cutterRepo.save(oldCutter);
        return cutterMapper.mapCutterToCutterDto(savedCutter);
    }
}
