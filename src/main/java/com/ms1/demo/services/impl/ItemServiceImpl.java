package com.ms1.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1.demo.model.Item;
import com.ms1.demo.repository.ItemRepository;
import com.ms1.demo.services.ItemService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        return repository.save(item);
    }

    @Override
    public Item updateItem(Item item, Long id) {
        if(repository.existsById(id)){
            log.info("id: " + Long.toString(id) + " Found");
            return repository.save(item);
        } else {
            log.info("id: " + Long.toString(id) + " Found");
            return null;
        }
    }

    @Override
    public void deleteitem(Long id) {
        repository.deleteById(id);
    }
    
}
