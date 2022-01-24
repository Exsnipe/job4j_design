package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public SimpleArrayList() {
        this.container = (T[]) new Object[10];
    }

    @Override
    public void add(T value) {
        checkContainerSize();
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T oldElement = get(index);
        container[index] = newValue;
        return oldElement;
    }

    @Override
    public T remove(int index) {
        T removable = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return removable;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size());
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
        private final int expectedModCount = modCount;
        private int indexIterator = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return indexIterator < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[indexIterator++];
            }

        };
    }

    private void checkContainerSize() {
        if (size == container.length - 1) {
            container = Arrays.copyOf(container, container.length == 0 ? 2 : container.length * 2);
        }
    }

}
