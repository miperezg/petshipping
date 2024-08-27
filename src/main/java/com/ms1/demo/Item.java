package com.ms1.demo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Item implements Serializable{
    private String id;
    private String sku;
    private String itemName;
    private String description;
    private int price;
    private int quantity;
    private PetTypeEnum petType;
    private SizeEnum size;

    public int GetTotal(){
        return price * quantity;
    }
}

