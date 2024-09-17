package com.ms1.demo.controller;


import com.ms1.demo.model.Address;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ms1.demo.services.AddressService;

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

@RestController
@Slf4j
@RequestMapping("/address")
public class AddressController{

    @Autowired
    private AddressService service;
    

    @GetMapping
    public List<Address> getAllItems() {
        return service.getAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return service.getAddressById(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return service.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updatAddress(@PathVariable Long id, @RequestBody Address address) {
        return service.updateAddress(address, id);
    }
    
    @DeleteMapping("/")
    public void deleteAddress(@PathVariable Long id){
        service.deleteAddress(id);
    }
    
}
