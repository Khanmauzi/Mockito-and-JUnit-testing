package com.learning.unittesting.unittesting.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Service
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private int id;
    private String name;
    private int price;
    private int quantity;

    @Transient
    private int value;

    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
