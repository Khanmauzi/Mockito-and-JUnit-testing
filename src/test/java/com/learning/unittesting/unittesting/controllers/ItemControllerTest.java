package com.learning.unittesting.unittesting.controllers;

import com.learning.unittesting.unittesting.models.Item;
import com.learning.unittesting.unittesting.services.ItemBusinessServcie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessServcie itemBusinessServcie;            //mocking itemBusinessService


    @Test
    public void dummyItem_basic() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":100,\"quantity\":10}"))
                .andReturn();

    }

    @Test
    public void itemFromBusinessService() throws Exception {
        when(itemBusinessServcie.retreiveHardcodeItem()).thenReturn(new Item(1,"Ball", 100, 10));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":100,\"quantity\":10}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItem() throws Exception {
        when(itemBusinessServcie.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3",20,20)
                        )
        );
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2, name:Item2, price:10, quantity:10}, {id:3, name:Item3, price:20, quantity:20}]"))
                .andReturn();
    }
}
