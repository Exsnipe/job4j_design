package ru.job4j;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
        cursor = data.next();
    }

    @Override
    public boolean hasNext() {
        while (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!cursor.hasNext()) {
            throw new NoSuchElementException();
        }
        T rsl = cursor.next();
        if (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }
        return rsl;
    }
}
