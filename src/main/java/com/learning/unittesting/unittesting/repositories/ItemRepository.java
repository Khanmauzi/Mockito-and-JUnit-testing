package com.learning.unittesting.unittesting.repositories;

import com.learning.unittesting.unittesting.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
