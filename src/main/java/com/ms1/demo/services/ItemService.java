package com.ms1.demo.services;

import java.util.List;
import java.util.Optional;

import com.ms1.demo.model.Item;

public interface ItemService{
    List<Item> getAllItems();
    Optional<Item> getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Item item, Long id);
    void deleteitem(Long id);
}