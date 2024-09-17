package com.ms1.demo.services;


import java.util.List;
import java.util.Optional;

import com.ms1.demo.model.Address;

public interface AddressService {
    List<Address> getAllAddress();
    Optional<Address> getAddressById(Long id);
    Address createAddress(Address address);
    Address updateAddress(Address address, Long id);
    void deleteAddress(Long id); 
}
