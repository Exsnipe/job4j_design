package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class MergeTest {
    @Test
    public void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        int[] result = Merge.mergesort(array);
        assertThat(result).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    public void whenArrayIsEmpty() {
        int[] array = {};
        int[] emptyResult = Merge.mergesort(array);
        assertThat(emptyResult).isEmpty();
    }

    @Test
    public void whenAllElementsAreEqual() {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1};
        assertThat(Merge.mergesort(array)).containsExactly(array);
    }
}