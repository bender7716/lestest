package org.example.mapper;

import org.example.dto.baguette.BaguetteDto;
import org.example.entity.Baguette;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaguetteMapper {
     Baguette mapBaguetteDtoToBaguette(BaguetteDto baguetteDto);
     BaguetteDto mapBaguetteToBaguetteDto(Baguette baguette);

     List<Baguette> mapBaguetteDtoListToBaguetteList(List<BaguetteDto> baguetteDtoList);
     List<BaguetteDto> mapBaguetteListToBaguetteDtoList(List<Baguette> baguetteList);

     void merge(@MappingTarget Baguette target, Baguette source);
}
