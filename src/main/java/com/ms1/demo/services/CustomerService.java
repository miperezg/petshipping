package com.ms1.demo.services;

import java.util.List;
import java.util.Optional;

import com.ms1.demo.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Long id);
    void deleteCustomer(Long id); 
}
