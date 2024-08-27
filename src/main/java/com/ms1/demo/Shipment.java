package com.ms1.demo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Shipment implements Serializable{

    private String id; 
    private ShippingCompanyEnum shippingCompany;
    private String trackingNumber;
    private ShippingStatusEnum status;
    private Address address;
    private LocalDateTime creationDate; 
    private LocalDateTime estimatedDeliveryDate;
    private Order order;
}
