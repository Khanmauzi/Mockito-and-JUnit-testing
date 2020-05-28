package com.learning.unittesting.unittesting.controllers;

import com.learning.unittesting.unittesting.models.Item;
import com.learning.unittesting.unittesting.services.ItemBusinessServcie;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ItemController {

    @Autowired
    private ItemBusinessServcie itemBusinessServcie;


    @GetMapping("/dummy-item")
    public Item  dummyItem() {
        Item item = new Item();
        item.setId(1);
        item.setName("Ball");
        item.setPrice(100);
        item.setQuantity(10);
        return item;
    }

    @GetMapping("/item-from-business-service")
    public Item  itemFromBusinessServcie() {
        return itemBusinessServcie.retreiveHardcodeItem();
    }
}
