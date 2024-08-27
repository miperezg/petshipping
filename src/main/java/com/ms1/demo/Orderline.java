package com.ms1.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Orderline {
    private String id;
    private Item item;
    private Integer Quantity;
}
