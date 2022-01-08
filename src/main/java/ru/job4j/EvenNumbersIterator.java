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
        int i = index;
        while (data[i] % 2 != 0 && i < data.length - 1) {
            i++;
        }
        index = i;
        return data[i] % 2 == 0;
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
