package org.example.mapper;

import org.example.dto.workplace.WorkplaceDto;
import org.example.entity.TechnologicalProcess;
import org.example.entity.Workplace;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface WorkplaceMapper {
    Workplace mapWorkplaceDtoToWorkplace(WorkplaceDto workplaceDto);

    WorkplaceDto mapWorkplaceToWorkplaceDto(Workplace workplace);

    @Mapping(target = "technologicalProcesses", source = "technologicalProcessSet")
    WorkplaceDto mapWorkplaceWithActiveTechnologicalProcessToWorkplaceDto(Workplace workplace, Set<TechnologicalProcess> technologicalProcessSet);

    List<Workplace> mapWorkplaceDtoListToWorkplaceList(List<WorkplaceDto> workplaceDtoList);

    List<WorkplaceDto> mapWorkplaceListToWorkplaceDtoList(List<Workplace> workplaceList);

    void merge(@MappingTarget Workplace target, Workplace source);
}
