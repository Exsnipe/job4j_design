package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MaxMinTest {
    @Test
    public void whenIntWithNaturalOrder() {
        MaxMin maxMin = new MaxMin();
        int max = maxMin.max(List.of(6, 2, 3, 6, 2, 8, 1, 4, 5, 15), Comparator.naturalOrder());
        assertThat(max).isEqualTo(15);
    }

    @Test
    public void whenModel2IsMax() {
        MaxMin maxMin = new MaxMin();
        Model1 max = maxMin.max(List.of(
            new Model1(1, 'a'),
            new Model1(10, 'b'),
            new Model1(6, 'd')
        ), new Comparator1());
        assertThat(max).isEqualTo(new Model1(10, 'b'));
    }

    @Test
    public void whenModel3IsMax() {
        MaxMin maxMin = new MaxMin();
        Model1 max = maxMin.max(List.of(
                new Model1(1, 'a'),
                new Model1(10, 'b'),
                new Model1(10, 'd'),
                new Model1(4, 'h')
        ), new Comparator1());
        assertThat(max).isEqualTo(new Model1(10, 'd'));
    }

    @Test
    public void whenIntWithNaturalOrderMin() {
        MaxMin maxMin = new MaxMin();
        int max = maxMin.min(List.of(6, 2, 3, 6, 2, 8, 1, 4, 5, 15), Comparator.naturalOrder());
        assertThat(max).isEqualTo(1);
    }

    @Test
    public void whenModel1IsMin() {
        MaxMin maxMin = new MaxMin();
        Model1 max = maxMin.min(List.of(
                new Model1(1, 'a'),
                new Model1(10, 'b'),
                new Model1(6, 'd')
        ), new Comparator1());
        assertThat(max).isEqualTo(new Model1(1, 'a'));
    }

    @Test
    public void whenModel2IsMin() {
        MaxMin maxMin = new MaxMin();
        Model1 min = maxMin.min(List.of(
                new Model1(1, 'b'),
                new Model1(1, 'a'),
                new Model1(10, 'd'),
                new Model1(4, 'h')
        ), new Comparator1());
        assertThat(min).isEqualTo(new Model1(1, 'a'));
    }

}