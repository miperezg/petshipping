package com.ms1.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1.demo.model.Order;
import com.ms1.demo.repository.OrderRepository;
import com.ms1.demo.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        if(repository.existsById(id)){
            log.info("id: " + Long.toString(id) + " Found");
            return repository.save(order);
        } else {
            log.info("id: " + Long.toString(id) + " Not Found");
            return null;
        } 
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
    
}
