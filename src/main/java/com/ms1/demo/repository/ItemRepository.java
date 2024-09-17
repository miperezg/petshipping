package com.ms1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms1.demo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
