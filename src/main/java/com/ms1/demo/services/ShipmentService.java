package com.ms1.demo.services;

import java.util.List;
import java.util.Optional;

import com.ms1.demo.model.Shipment;

public interface ShipmentService {
    List<Shipment> getAllShipments();
    Optional<Shipment> getShipmentById(Long id);
    Shipment createShipment(Shipment shipment);
    Shipment updateShipment(Shipment shipment, Long id);
    void deleteShipment(Long id); 
}
