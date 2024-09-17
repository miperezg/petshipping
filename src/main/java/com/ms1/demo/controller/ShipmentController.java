package com.ms1.demo.controller;


import com.ms1.demo.model.Shipment;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ms1.demo.services.ShipmentService;

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
@RequestMapping("/shipments")
public class ShipmentController{

    @Autowired
    private ShipmentService service;
    

    @GetMapping
    public List<Shipment> getAllItems() {
        return service.getAllShipments();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getShipmentById(@PathVariable Long id) {
        return service.getShipmentById(id);
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return service.createShipment(shipment);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody Shipment shipment) {
        return service.updateShipment(shipment, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id){
        service.deleteShipment(id);
    }
    
}
