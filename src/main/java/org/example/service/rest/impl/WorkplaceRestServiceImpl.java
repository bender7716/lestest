package org.example.service.rest.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.workplace.WorkplaceDto;
import org.example.entity.Order;
import org.example.entity.TechnologicalProcess;
import org.example.entity.Workplace;
import org.example.mapper.WorkplaceMapper;
import org.example.repository.WorkplaceRepo;
import org.example.service.rest.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkplaceRestServiceImpl implements CrudService<WorkplaceDto> {

    private final WorkplaceRepo workplaceRepo;
    private final WorkplaceMapper workplaceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WorkplaceDto> getAll() {
        List<Workplace> workplaces = workplaceRepo.findAll();
        return workplaces.stream().map(workplace -> {
            Set<TechnologicalProcess> technologicalProcessSet = filterTechnologicalProcessIsActive(workplace);
            return workplaceMapper.mapWorkplaceWithActiveTechnologicalProcessToWorkplaceDto(workplace, technologicalProcessSet);
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public WorkplaceDto getById(Long id) {
        Workplace workplace = workplaceRepo.findById(id).orElseThrow();
        Set<TechnologicalProcess> technologicalProcessSet = filterTechnologicalProcessIsActive(workplace);
        return workplaceMapper.mapWorkplaceWithActiveTechnologicalProcessToWorkplaceDto(workplace, technologicalProcessSet);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        workplaceRepo.deleteById(id);
    }

    @Override
    @Transactional
    public WorkplaceDto create(WorkplaceDto dto) {
        Workplace workplace = workplaceMapper.mapWorkplaceDtoToWorkplace(dto);
        Workplace savedWorkplace = workplaceRepo.save(workplace);
        return workplaceMapper.mapWorkplaceToWorkplaceDto(savedWorkplace);
    }

    @Override
    @Transactional
    public WorkplaceDto update(WorkplaceDto dto, Long id) {
        Workplace oldWorkplace = workplaceRepo.findById(id).orElseThrow();
        Workplace newWorkplace = workplaceMapper.mapWorkplaceDtoToWorkplace(dto);
        workplaceMapper.merge(oldWorkplace, newWorkplace);
        Workplace savedWorkplace = workplaceRepo.save(oldWorkplace);
        return workplaceMapper.mapWorkplaceToWorkplaceDto(savedWorkplace);
    }

    private Set<TechnologicalProcess> filterTechnologicalProcessIsActive(Workplace workplace) {
        Set<TechnologicalProcess> technologicalProcessList = new HashSet<>();
        workplace.getTechnologicalProcesses().forEach(technologicalProcess -> {
            if (isActiveTechnologicalProcesses (technologicalProcess.getOrder(), technologicalProcess))
                technologicalProcessList.add(technologicalProcess);
        });
        return technologicalProcessList;
    }

    private boolean isActiveTechnologicalProcesses(Order order, TechnologicalProcess nowTechnologicalProcess) {
        List<TechnologicalProcess> technologicalProcessList = order.getTechnologicalProcesses().stream()
                .sorted(Comparator.comparing(TechnologicalProcess::getOperationCode)).toList();
        int index = technologicalProcessList.indexOf(nowTechnologicalProcess);
        if (index <= 0)
            return Objects.isNull(technologicalProcessList.get(index).getTimeFinishWork());
        else
            return Objects.nonNull(technologicalProcessList.get(index - 1).getTimeFinishWork()) &&
                    (Objects.isNull(technologicalProcessList.get(index).getTimeStartWork()) ||
                            Objects.isNull(technologicalProcessList.get(index).getTimeFinishWork()));
    }
}
