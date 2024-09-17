package com.ms1.demo.services;


import java.util.List;
import java.util.Optional;

import com.ms1.demo.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Order order, Long id);
    void deleteOrder(Long id);
}
