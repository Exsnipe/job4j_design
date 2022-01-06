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
        int i;
        for (i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                break;
            }
        }
        return i == index;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
