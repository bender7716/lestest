package org.example.mapper;

import org.example.dto.order.OrderDto;
import org.example.entity.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
     Order mapOrderDtoToOrder(OrderDto orderDto);
     OrderDto mapOrderToOrderDto(Order order);
     List<Order> mapOrderDtoListToOrderList(List<OrderDto> orderDtoList);
     List<OrderDto> mapOrderListToOrderDtoList(List<Order> orderList);

     @Mapping(target = "technologicalProcesses", ignore = true)
     @Mapping(target = "cutters", ignore = true)
     @Mapping(target = "baguettes", ignore = true)
     void merge(@MappingTarget Order target, Order source);

     // добавляем ссылку на order внутрь технологических процессов
     @AfterMapping
     default void addOrderInTechnologicalProcess(@MappingTarget Order order){
          order.getTechnologicalProcesses().forEach(technologicalProcess -> technologicalProcess.setOrder(order));
     }
}
