package ru.job4j.list;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements List1<E> {
    transient int size;
    int modCount;
    transient Node<E> first;
    transient Node<E> last;

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node(l, value, null);
        if (l == null) {
            first = newNode;
            last = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Iterator<E> iterator = this.iterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        if (!iterator.hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        return iterator.next();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public SimpleLinkedList.Node<E> currentNode = new SimpleLinkedList.Node<>(null, null, first);
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentNode.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = currentNode.next.item;
                currentNode = currentNode.next;
                return result;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
