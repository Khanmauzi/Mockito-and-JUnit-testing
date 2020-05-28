package com.learning.unittesting.unittesting.services;

import com.learning.unittesting.unittesting.models.Item;
import com.learning.unittesting.unittesting.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServcie {
    @Autowired
    Item item;

    @Autowired
    private ItemRepository itemRepository;
    public Item retreiveHardcodeItem(){
        item.setId(1);
        item.setName("Ball");
        item.setPrice(100);
        item.setQuantity(10);
        return item;
    }
    public List<Item> retrieveAllItems() {
        return itemRepository.findAll();
    }
}
