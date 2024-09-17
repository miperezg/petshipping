package com.ms1.demo.controller;


import com.ms1.demo.model.Order;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ms1.demo.services.OrderService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order putMethodName(@PathVariable Long id, @RequestBody Order order) {
        return service.updateOrder(order, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        service.deleteOrder(id);
    }
    
}
