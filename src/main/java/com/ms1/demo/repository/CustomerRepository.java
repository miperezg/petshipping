package com.ms1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms1.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
