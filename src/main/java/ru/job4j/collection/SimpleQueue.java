package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.getSize() == 0) {
            fullOut();
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }

    public void fullOut() {
        while (in.getSize() > 0) {
            out.push(in.pop());
        }
    }
 }
