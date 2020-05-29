package com.learning.unittesting.unittesting.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning() {
        String responseFromServcie = "[{\"id\":1001,\"name\":\"iteme1\",\"price\":10,\"quantity\":20,\"value\":200}," +
                "{\"id\":1002,\"name\":\"item2\",\"price\":20,\"quantity\":40,\"value\":800}," +
                "{\"id\":1003,\"name\":\"item3\",\"price\":15,\"quantity\":25,\"value\":375}" +
                "]";
        DocumentContext context = JsonPath.parse(responseFromServcie);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        System.out.println(context.read("$..id").toString());

        System.out.println(context.read("$..[1]").toString());   //return element at index1
        System.out.println(context.read("$..[0:2]").toString());   //return element at index 0 and 1
        System.out.println(context.read("$..[?(@.name=='item3')]").toString()); //conditional return
    }
}
