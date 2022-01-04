package ru.job4j;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return findNextEven() >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = findNextEven();
        if (index >= 0) {
            return data[index++];
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private int findNextEven() {
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }
}
