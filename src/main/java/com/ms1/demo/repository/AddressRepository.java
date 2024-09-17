package com.ms1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms1.demo.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
