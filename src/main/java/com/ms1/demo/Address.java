package com.ms1.demo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable{
    private String id;
    private String calle;
    private String comuna;
    private String ciudad;
    private String region;
}
