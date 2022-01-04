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
        for (int indexEl = index; indexEl < data.length; indexEl++) {
            if (data[indexEl] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int indexEl = index; indexEl < data.length; indexEl++) {
            if (data[indexEl] % 2 == 0) {
                index = indexEl + 1;
                return data[indexEl];
            }
        }
        return -1;
    }
}
