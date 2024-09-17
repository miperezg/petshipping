package com.ms1.demo.controller;


import com.ms1.demo.model.Customer;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ms1.demo.services.CustomerService;

import lombok.extern.slf4j.Slf4j;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController{

    @Autowired
    private CustomerService service;
    

    @GetMapping
    public List<Customer> getAllItems() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@RequestParam Long id) {
        return service.getCustomerById(id);
    }
    

    @PostMapping
    public Customer createItem(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return service.updateCustomer(customer, id);
    }
    
    @DeleteMapping
    public void deleteItem(@PathVariable Long id){
        service.deleteCustomer(id);
    }
    
}
