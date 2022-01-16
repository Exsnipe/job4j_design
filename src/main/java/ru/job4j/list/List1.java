package ru.job4j.list;

public interface List1<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
