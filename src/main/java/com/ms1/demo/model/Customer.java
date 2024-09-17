package com.ms1.demo.model;

import java.io.Serializable;
import java.util.List;


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
@Table(name = "customer")
public class Customer implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
