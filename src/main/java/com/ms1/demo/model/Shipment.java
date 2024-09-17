package com.ms1.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ms1.demo.utils.enums.ShippingCompanyEnum;
import com.ms1.demo.utils.enums.ShippingStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shipment")
public class Shipment implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipment")
    private Long id; 
    private ShippingCompanyEnum shippingCompany;
    private String trackingNumber;
    private ShippingStatusEnum status;
    private Address address;
    private LocalDateTime creationDate; 
    private LocalDateTime estimatedDeliveryDate;
    @OneToOne
    private Order order;
}
