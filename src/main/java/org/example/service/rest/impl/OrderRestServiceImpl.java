package org.example.service.rest.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.order.OrderDto;
import org.example.entity.Order;
import org.example.mapper.OrderMapper;
import org.example.repository.OrderRepo;
import org.example.service.rest.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderRestServiceImpl implements CrudService<OrderDto> {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAll() {
        List<Order> orders = orderRepo.findAll();
        return orderMapper.mapOrderListToOrderDtoList(orders);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDto getById(Long id) {
        Order order = orderRepo.findById(id).orElseThrow();
        return orderMapper.mapOrderToOrderDto(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    @Transactional
    public OrderDto create(OrderDto dto) {
        Order order = orderMapper.mapOrderDtoToOrder(dto);
        Order savedOrder = orderRepo.save(order);
        return orderMapper.mapOrderToOrderDto(savedOrder);
    }

    @Override
    @Transactional
    public OrderDto update(OrderDto dto, Long id) {
        Order oldOrder = orderRepo.findById(id).orElseThrow();
        Order newOrder = orderMapper.mapOrderDtoToOrder(dto);
        orderMapper.merge(oldOrder, newOrder);
        Order savedOrder = orderRepo.save(oldOrder);
        return orderMapper.mapOrderToOrderDto(savedOrder);
    }
}
