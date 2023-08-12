package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    private <T> T findValue(List<T> value, Comparator<T> comparator) {
        if (value == null) {
            throw new IllegalArgumentException("value is empty");
        }
        T searchedValue = value.get(0);
        for (T curVal : value) {
            searchedValue = comparator.compare(searchedValue, curVal) > 0 ? searchedValue : curVal;
        }
        return searchedValue;
    }
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator.reversed());
    }
}
