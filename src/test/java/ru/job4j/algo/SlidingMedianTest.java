package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SlidingMedianTest {
    @Test
    public void whenWindowIsEven() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] expected = {1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000};
        SlidingMedian sm = new SlidingMedian();
        double[] result = sm.medianSlidingWindow(input, k);
        assertThat(result).containsExactly(expected);
    }
}