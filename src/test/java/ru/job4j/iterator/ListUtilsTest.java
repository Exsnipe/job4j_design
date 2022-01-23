package ru.job4j.iterator;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIfEqual2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 2, 5));
        ListUtils.removeIf(input, (p) -> p == 2);
        assertThat(input, is(Arrays.asList(0, 1, 3, 4, 5)));
    }

    @Test
    public void whenNothingRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 2, 5));
        ListUtils.removeIf(input, (p) -> p == 6);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4, 2, 5)));
    }

    @Test
    public void whenReplaceTo100() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 2, 5));
        ListUtils.replaceIf(input, (p) -> p == 2, 100);
        assertThat(input, is(Arrays.asList(0, 1, 100, 3, 4, 100, 5)));
    }

    @Test
    public void whenNothingReplace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 2, 5));
        ListUtils.replaceIf(input, (p) -> p == 6, 100);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4, 2, 5)));
    }

    @Test
    public void whenReplaceAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 2, 5));
        List<Integer> element = new ArrayList<>(Arrays.asList(0, 2, 4));
        ListUtils.removeAll(list, element);
        assertThat(list, is(Arrays.asList(1, 3, 5)));
    }

}