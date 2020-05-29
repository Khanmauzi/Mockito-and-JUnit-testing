package com.learning.unittesting.unittesting.assertjtest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,45,30);

        assertThat(numbers).hasSize(3)
                .contains(12,45)
                .allMatch(x -> x >10);


        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }
}
