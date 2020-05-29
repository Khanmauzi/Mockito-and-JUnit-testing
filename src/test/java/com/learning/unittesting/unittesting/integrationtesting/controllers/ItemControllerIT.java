package com.learning.unittesting.unittesting.integrationtesting.controllers;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response = this.testRestTemplate.getForObject("/all-items-from-database",String.class);
        JSONAssert.assertEquals("[{\"id\":1001,\"name\":\"iteme1\",\"price\":10,\"quantity\":20,\"value\":200},{\"id\":1002,\"name\":\"item2\",\"price\":20,\"quantity\":40,\"value\":800},{\"id\":1003,\"name\":\"item3\",\"price\":15,\"quantity\":25,\"value\":375}]",
                response, false);

    }
}
