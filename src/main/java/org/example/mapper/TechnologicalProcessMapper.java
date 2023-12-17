package org.example.mapper;

import org.example.dto.technologicalprocess.TechnologicalProcessDto;
import org.example.entity.TechnologicalProcess;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologicalProcessMapper {
     TechnologicalProcess mapTechnologicalProcessDtoToTechnologicalProcess(TechnologicalProcessDto technologicalProcessDto);
     TechnologicalProcessDto mapTechnologicalProcessToTechnologicalProcessDto(TechnologicalProcess technologicalProcess);
     List<TechnologicalProcess> mapTechnologicalProcessDtoListToTechnologicalProcessList(List<TechnologicalProcessDto> technologicalProcessDtoList);
     List<TechnologicalProcessDto> mapTechnologicalProcessListToTechnologicalProcessDtoList(List<TechnologicalProcess> technologicalProcessList);

     void merge(@MappingTarget TechnologicalProcess target, TechnologicalProcess source);
}
