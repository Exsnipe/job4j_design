package ru.job4j.list;

import org.w3c.dom.Node;

import java.util.*;

public class SimpleLinkedList<E> implements List1<E> {
    private transient int size;
    private int modCount;
    private transient Node<E> first;
    private transient Node<E> last;

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
        Objects.checkIndex(index, size);
        Node<E> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private SimpleLinkedList.Node<E> currentNode =
                    new SimpleLinkedList.Node<>(null, null, first);
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
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
