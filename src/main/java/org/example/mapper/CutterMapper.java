package org.example.mapper;

import org.example.dto.cutter.CutterDto;
import org.example.entity.Cutter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CutterMapper {
     Cutter mapCutterDtoToCutter(CutterDto cutterDto);
     CutterDto mapCutterToCutterDto(Cutter cutter);
     List<Cutter> mapCutterDtoListToCutterList(List<CutterDto> cutterDtoList);
     List<CutterDto> mapCutterListToCutterDtoList(List<Cutter> cutterList);

     void merge(@MappingTarget Cutter target, Cutter source);
}
