package com.example.collection.CollectionExample.controller;

import com.example.collection.CollectionExample.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/add")
    public void add(@RequestParam List<Integer> items) {
        orderService.add(items);
    }

    @GetMapping(path = "/get")
    public List<Integer> get() {
        return orderService.get();
    }
}
