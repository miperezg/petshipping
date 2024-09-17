package com.ms1.demo.controller;


import com.ms1.demo.model.Item;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ms1.demo.services.ItemService;

import lombok.extern.slf4j.Slf4j;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Slf4j
@RequestMapping("/items")
public class ItemController{

    @Autowired
    private ItemService service;
    

    @GetMapping
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemsById(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return service.createItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return service.updateItem(item, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        service.deleteitem(id);
    }
    
}
