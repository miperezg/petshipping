package com.ms1.demo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order implements Serializable{
    private String id;
    private String orderNumber;
    private OrderStatusEnum orderStatus;
    private Customer customer;
    private List<Item> items;
}
