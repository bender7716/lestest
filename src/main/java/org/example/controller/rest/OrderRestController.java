package org.example.controller.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.order.OrderDto;
import org.example.service.rest.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/order")
public class OrderRestController {


    private final CrudService<OrderDto> orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDto>>  getAll() {
        List<OrderDto> allOrders = orderService.getAll();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long id){
        OrderDto orderDto = orderService.getById(id);
        return ResponseEntity.ok(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDto> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping()
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto){
        OrderDto orderDto = orderService.create(dto);
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> update(@PathVariable Long id, @RequestBody OrderDto dto){
        OrderDto orderDto = orderService.update(dto, id);
        return ResponseEntity.ok(orderDto);
    }


}
