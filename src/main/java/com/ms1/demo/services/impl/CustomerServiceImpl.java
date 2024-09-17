package com.ms1.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1.demo.model.Customer;
import com.ms1.demo.repository.CustomerRepository;
import com.ms1.demo.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        if(repository.existsById(id)){
            log.info("id: " + Long.toString(id) + " Found");
            return repository.save(customer);
        } else{
            log.info("id: " + Long.toString(id) + " Not Found");
            return null;
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
    
}
