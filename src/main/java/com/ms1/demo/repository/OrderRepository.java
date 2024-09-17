package com.ms1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms1.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
