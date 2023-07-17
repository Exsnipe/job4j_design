package ru.job4j;

import java.util.Arrays;

public class SimpleSet {
    private String[] container = new String[2];
    private int size;

    public boolean add(String value) {
        if (size == container.length) {
            grow();
        }
        boolean result = !contains(value);
        if (result) {
            container[size++] = value;
        }
        return result;
    }

    private boolean contains(String value) {
        boolean result = false;
        for (String str : container) {
            if (value.equals(str)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private void grow() {
        int length = container.length * 2;
        container = Arrays.copyOf(container, container.length * 2);
    }
}