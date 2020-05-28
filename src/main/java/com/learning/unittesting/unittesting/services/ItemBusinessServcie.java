package com.learning.unittesting.unittesting.services;

import com.learning.unittesting.unittesting.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessServcie {
    @Autowired
    Item item;
    public Item retreiveHardcodeItem(){
        item.setId(1);
        item.setName("Ball");
        item.setPrice(100);
        item.setQuantity(10);
        return item;
    }
}
