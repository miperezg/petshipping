package com.ms1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms1.demo.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
    
}
