package org.example.service.rest.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.technologicalprocess.TechnologicalProcessDto;
import org.example.entity.TechnologicalProcess;
import org.example.mapper.TechnologicalProcessMapper;
import org.example.repository.TechnologicalProcessRepo;
import org.example.service.rest.CrudService;
import org.example.service.rest.TechnologicalProcessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologicalProcessRestServiceImpl implements CrudService<TechnologicalProcessDto>, TechnologicalProcessService {

    private final TechnologicalProcessRepo technologicalProcessRepo;
    private final TechnologicalProcessMapper technologicalProcessMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TechnologicalProcessDto> getAll() {
        List<TechnologicalProcess> technologicalProcesses = technologicalProcessRepo.findAll();
        return technologicalProcessMapper.mapTechnologicalProcessListToTechnologicalProcessDtoList(technologicalProcesses);
    }

    @Override
    @Transactional(readOnly = true)
    public TechnologicalProcessDto getById(Long id) {
        TechnologicalProcess technologicalProcess = technologicalProcessRepo.findById(id).orElseThrow();
        return technologicalProcessMapper.mapTechnologicalProcessToTechnologicalProcessDto(technologicalProcess);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        technologicalProcessRepo.deleteById(id);
    }

    @Override
    @Transactional
    public TechnologicalProcessDto create(TechnologicalProcessDto dto) {
        TechnologicalProcess technologicalProcess = technologicalProcessMapper.mapTechnologicalProcessDtoToTechnologicalProcess(dto);
        TechnologicalProcess savedTechnologicalProcess = technologicalProcessRepo.save(technologicalProcess);
        return technologicalProcessMapper.mapTechnologicalProcessToTechnologicalProcessDto(savedTechnologicalProcess);
    }

    @Override
    @Transactional
    public TechnologicalProcessDto update(TechnologicalProcessDto dto, Long id) {
        TechnologicalProcess oldTechnologicalProcess = technologicalProcessRepo.findById(id).orElseThrow();
        TechnologicalProcess newTechnologicalProcess = technologicalProcessMapper.mapTechnologicalProcessDtoToTechnologicalProcess(dto);
        technologicalProcessMapper.merge(oldTechnologicalProcess, newTechnologicalProcess);
        TechnologicalProcess savedTechnologicalProcess = technologicalProcessRepo.save(oldTechnologicalProcess);
        return technologicalProcessMapper.mapTechnologicalProcessToTechnologicalProcessDto(savedTechnologicalProcess);
    }

    @Override
    @Transactional
    public void startJob(Long id) {
        TechnologicalProcess technologicalProcess = technologicalProcessRepo.findById(id).orElseThrow();
        technologicalProcess.setTimeStartWork(Timestamp.valueOf(LocalDateTime.now()));
        technologicalProcessRepo.save(technologicalProcess);
    }

    @Override
    @Transactional
    public void endJob(Long id) {
        TechnologicalProcess technologicalProcess = technologicalProcessRepo.findById(id).orElseThrow();
        technologicalProcess.setTimeFinishWork(Timestamp.valueOf(LocalDateTime.now()));
        technologicalProcessRepo.save(technologicalProcess);
    }
}
