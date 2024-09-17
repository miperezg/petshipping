package com.ms1.demo.model;

import java.io.Serializable;
import java.util.List;


import com.ms1.demo.utils.enums.OrderStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    private String orderNumber;
    private OrderStatusEnum orderStatus;
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<Item> items;
}
