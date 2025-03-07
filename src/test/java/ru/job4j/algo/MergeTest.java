package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class MergeTest {
    @Test
    void whenSortedThenOk(){
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        int[] result = Merge.mergesort(array);
        Arrays.stream(result).forEach(System.out::println);
        assertThat(result).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }
}