/**
 * @Author: Mauzi
 * This test case test for the business logic of ItemBusinessService
 */

package com.learning.unittesting.unittesting.services;

import com.learning.unittesting.unittesting.models.Item;
import com.learning.unittesting.unittesting.repositories.ItemRepository;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessServcie itemBusinessServcie;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void testRetreiveHardcodeItems() {
        Item item = itemBusinessServcie.retreiveHardcodeItem();
        assertEquals("Ball", item.getName());
    }

    @Test
    public void testRetreiveAllItems() throws JSONException {
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(1001, "Item1", 10, 20),
                        new Item(1002, "Item2", 20, 40),
                        new Item(1003, "Item3", 15, 25)
                )
        );
//        assertEquals("[{\"id\":1001,\"name\":\"iteme1\",\"price\":10,\"quantity\":20,\"value\":200},{\"id\":1002,\"name\":\"item2\",\"price\":20,\"quantity\":40,\"value\":800},{\"id\":1003,\"name\":\"item3\",\"price\":15,\"quantity\":25,\"value\":375}]",
//                itemBusinessServcie.retrieveAllItems());
        List<Item> items = itemBusinessServcie.retrieveAllItems();
        assertEquals(200, items.get(0).getPrice() * items.get(0).getQuantity());
        assertEquals(800, items.get(1).getPrice() * items.get(1).getQuantity());
        assertEquals(375, items.get(2).getPrice() * items.get(2).getQuantity());

        assertThat(items, hasSize(3));
        //assertThat(items, hasItems({"id":1001, name:item1, price:10, quantity:20, value:200}));
       // assertThat(items,hasItems("{id:1001, name:item1, price:10, quantity:20, value:200}", "{id:1002, name:item2, price:20, quantity:40, value:800}", "{id:1003, name:item3, price:15, quantity:25, value:375}"));
    }
}
