package org.example.service.mvc.Impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Order;
import org.example.mapper.OrderMapper;
import org.example.repository.OrderRepo;
import org.example.service.mvc.CrudMvcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderMvcServiceImpl implements CrudMvcService<Order> {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Order> list() {
        return orderRepo.findAll();
    }

    @Override
    @Transactional
    public Order create() {
        return new Order();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void save(Long id, Order item) {
        Order orderFromDB;
        if (Objects.isNull(id))
            orderFromDB = new Order();
        else
            orderFromDB = getById(id);
        orderMapper.merge(orderFromDB, item);
        orderRepo.save(orderFromDB);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

}
