package com.ms1.demo.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;
    private String calle;
    private String comuna;
    private String ciudad;
    private String region;
    @ManyToOne
    private Customer customer;
}
