package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MaxMinTest {
    @Test
    public void whenModelOneIsMax() {
        MaxMin maxMin = new MaxMin();
        int max = maxMin.max(List.of(6, 2, 3, 6, 2, 8, 1, 4,5), Comparator.naturalOrder());
        assertThat(max).isEqualTo(8);
    }

}