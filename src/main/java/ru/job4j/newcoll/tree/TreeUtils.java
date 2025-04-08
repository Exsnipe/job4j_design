package ru.job4j.newcoll.tree;

import ru.job4j.collection.SimpleQueue;

import java.util.Queue;

public class TreeUtils<T> {

    public int countNode(Node<T> root) {
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
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        return null;
    }
}
