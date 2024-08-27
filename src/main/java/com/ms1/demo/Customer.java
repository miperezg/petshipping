package com.ms1.demo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable{
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Address> addresses;
}
