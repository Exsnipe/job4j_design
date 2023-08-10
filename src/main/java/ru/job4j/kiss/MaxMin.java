package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        if (value == null) {
            throw new IllegalArgumentException("value is empty");
        }
        T maxT = value.get(0);
        for (T curVal : value) {
            maxT = comparator.compare(maxT, curVal) > 0 ? maxT : curVal;
        }
        return maxT;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        if (value == null) {
            throw new IllegalArgumentException("value is empty");
        }
        T minT = value.get(0);
        for (T curVal : value) {
            minT = comparator.compare(minT, curVal) < 0 ? minT : curVal;
        }
        return minT;
    }
}
