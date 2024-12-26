package com.example.collection.CollectionExample.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class OrderServiceImpl implements OrderService{

    private List<Integer> listOrder = new ArrayList<>();

    public OrderServiceImpl(List<Integer> listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public List<Integer> add(List<Integer> items) {
        listOrder.addAll(items);
        return listOrder;
    }

    @Override
    public List<Integer> get() {
        return listOrder;
    }

}
