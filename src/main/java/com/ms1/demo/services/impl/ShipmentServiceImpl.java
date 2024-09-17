package com.ms1.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1.demo.model.Shipment;
import com.ms1.demo.repository.ShipmentRepository;
import com.ms1.demo.services.ShipmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    private ShipmentRepository repository;

    @Override
    public List<Shipment> getAllShipments() {
        return repository.findAll(); 
    }

    @Override
    public Optional<Shipment> getShipmentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return repository.save(shipment);
    }

    @Override
    public Shipment updateShipment(Shipment shipment, Long id) {
        if(repository.existsById(id)){
            log.info("id: " + Long.toString(id) + " Found");
            return repository.save(shipment);
        } else{
            log.info("id: " + Long.toString(id) + " Not Found");
            return null;
        }
    }

    @Override
    public void deleteShipment(Long id) {
        repository.deleteById(id);
    }
    
}
