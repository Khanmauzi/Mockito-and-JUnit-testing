package com.learning.unittesting.unittesting.hamcrestmatchers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12,45));
    }
}
