package ru.job4j.collection.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");

        System.out.println(deque.peek());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekLast());
    }
}
