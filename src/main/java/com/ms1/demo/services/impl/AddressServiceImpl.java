package com.ms1.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1.demo.model.Address;
import com.ms1.demo.repository.AddressRepository;
import com.ms1.demo.services.AddressService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository repository;

    @Override
    public List<Address> getAllAddress() {
        return repository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Address createAddress(Address address) {
        return repository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Long id) {
        if(repository.existsById(id)){
            log.info("id: " + Long.toString(id) + " Found");
            return repository.save(address);
        } else{
            log.info("id: " + Long.toString(id) + " Not Found");
            return null;
        }
    }

    @Override
    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }
    
}
