/**
 * @Author: Mauzi
 * This Class is for unit testing of data Layer(JPA Repository)
 */

package com.learning.unittesting.unittesting.data;

import com.learning.unittesting.unittesting.models.Item;
import com.learning.unittesting.unittesting.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        List<Item> items = itemRepository.findAll();
        assertEquals(3, items.size());
    }
}
