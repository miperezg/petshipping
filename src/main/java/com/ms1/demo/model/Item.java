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
@Table(name = "item")
public class Item implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;
    private String sku;
    private String itemName;
    private String description;
    private Integer price;
    private Integer quantity;
    private String petType;
    private String size;
    @ManyToOne
    private Order order;
}

