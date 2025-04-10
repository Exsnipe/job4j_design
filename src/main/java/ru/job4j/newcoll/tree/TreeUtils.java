package ru.job4j.newcoll.tree;

import ru.job4j.collection.ForwardLinked;
import ru.job4j.collection.SimpleQueue;

import java.util.Iterator;
import java.util.Queue;

public class TreeUtils<T> {

    public int countNode(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        queue.push(root);
        Node<T> currentElement;
        while (!queue.isEmpty()) {
            currentElement = queue.poll();
            count++;
            currentElement.getChildren().forEach(queue::push);
        }
            return count;
    }

    public Iterable<T> findAll(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleQueue<Node<T>> in = new SimpleQueue<>();
        SimpleQueue<T> out = new SimpleQueue<>();
        in.push(root);
        Node<T> currentElement;
        while (!in.isEmpty()) {
            currentElement = in.poll();
            currentElement.getChildren().forEach(in::push);
            out.push(currentElement.getValue());
        }
        return out;
    }
}
