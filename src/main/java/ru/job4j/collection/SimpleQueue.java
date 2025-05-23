package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> implements Iterable<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.getSize() == 0) {
            if (in.getSize() == 0) {
                throw new NoSuchElementException();
            }
            while (in.getSize() > 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }

    public boolean isEmpty() {
        return in.getSize() == 0 && out.getSize() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return in.getSize() > 0 || out.getSize() > 0;
            }

            @Override
            public T next() {
                return poll();
            }
        };
    }
}
