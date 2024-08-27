package com.ms1.demo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {

    private List<Order> orders = new ArrayList<>();
    private List<Shipment> shipments = new ArrayList<>();

    @Autowired
    private final ObjectMapper objectMapper;

    private void LoadOrderJson() throws IOException, StreamReadException, DatabindException{
        ClassPathResource resource = new ClassPathResource("static/orders.json");
        File file = resource.getFile();
        orders = objectMapper.readValue(file, new TypeReference<List<Order>>(){});
    }

    public MainController() throws StreamReadException, DatabindException, IOException{
        this.objectMapper = new ObjectMapper();
        try{
            LoadOrderJson();
        }
        catch(Exception e){
            log.info(e.getMessage());
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        if (orders.size() < 1){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/shipments")
    public ResponseEntity<List<Shipment>> getShipments(){
        if (shipments.size() < 1){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shipments, HttpStatus.OK);
    }

    @GetMapping("/shipments/order/{orderId}")
    public ResponseEntity<Shipment> createShipment(@PathVariable("orderId") String orderId){
        if(Objects.isNull(orderId) || orderId.length() < 1){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Order order = orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().orElse(null);
        if(Objects.isNull(order)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shipment shipment = shipmentFactory();
        shipment.setAddress(order.getCustomer().getAddresses().get(0));
        order.setOrderStatus(OrderStatusEnum.SHIPPED);
        shipment.setOrder(order);
        return new ResponseEntity<Shipment>(shipment, HttpStatus.OK);
    }

    @GetMapping("/shipments/moveStatus/{shipmentId}")
    public ResponseEntity<Shipment> moveStatus(@PathVariable("shipmentId") String shipmentId){
        if(Objects.isNull(shipmentId) || shipmentId.length() < 1){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shipment shipment = shipments.stream().filter(o -> o.getId().equals(shipmentId)).findFirst().orElse(null);
        if(Objects.isNull(shipment)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var ordinalStatus = shipment.getStatus().ordinal();
        if(ordinalStatus < ShippingStatusEnum.values().length){
            ordinalStatus++;
        }
        else if(ordinalStatus == ShippingStatusEnum.values().length){
            shipment.getOrder().setOrderStatus(OrderStatusEnum.DELIVERED);
        }
        shipment.setStatus(ShippingStatusEnum.values()[ordinalStatus]);
        shipments.add(shipment);
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }

    private Shipment shipmentFactory(){
        Shipment shipment = new Shipment();
        shipment.setId(Integer.toString(shipments.size() + 1));
        Random random = new Random();
        int randomCompany = random.nextInt(ShippingCompanyEnum.values().length);
        shipment.setShippingCompany(ShippingCompanyEnum.values()[randomCompany]);
        shipment.setStatus(ShippingStatusEnum.values()[0]);
        shipment.setCreationDate(LocalDateTime.now());
        shipment.setEstimatedDeliveryDate(shipment.getCreationDate().plusDays(3));
        shipment.setTrackingNumber(UUID.randomUUID().toString());
        return shipment; 
    }

    @GetMapping("/shipments/{id}")
    public ResponseEntity<Shipment> getShipment(
        @PathVariable("id") String id
    ){
        var stream = shipments.stream();
        var filtered =  stream.filter(ship -> ship.getId().equals(id));
        var found = filtered.findFirst().orElse(null);
        if (Objects.nonNull(found)){
            return new ResponseEntity<>(found ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
