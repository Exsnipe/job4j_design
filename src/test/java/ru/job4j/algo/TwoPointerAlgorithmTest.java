package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TwoPointerAlgorithmTest {
    @Test
    public void whenArraySorted() {
        int[] input = {-4, -2, 0, 2, 3, 5};
        int[] expectedArray = {0, 4, 4, 9, 16, 25};
        assertThat(TwoPointerAlgorithm.squareSortedArray(input)).isEqualTo(expectedArray);
    }

}