package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SimpleSetTest {
    @Test
    void whenAddSimilarThenFalse() {
        SimpleSet simpleSet = new SimpleSet();
        simpleSet.add("one");
        simpleSet.add("two");
        simpleSet.add("three");
        simpleSet.add("four");
        assertThat(simpleSet.add("one")).isFalse();
    }
}