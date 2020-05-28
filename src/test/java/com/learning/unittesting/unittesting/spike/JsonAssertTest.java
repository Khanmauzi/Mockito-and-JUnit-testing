package com.learning.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;



public class JsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":100,\"quantity\":10}";
    @Test
    public void jsonAssert_SrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":100,\"quantity\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_StrictFalse_WtihoutSpaceCharacters() throws JSONException {
        String expectedResponse = "{id: 1, name:Ball, price:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
