package ru.job4j.newcoll.tree;

import ru.job4j.collection.ForwardLinked;
import ru.job4j.collection.SimpleQueue;
import ru.job4j.collection.SimpleStack;

import java.util.Iterator;
import java.util.Optional;
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

    public boolean add(Node<T> root, T parent, T child) {
        if (root == null || parent == null || child == null) {
            throw new IllegalArgumentException();
        }
        Optional<Node<T>> linkOfParent = findByKey(root, parent);
        if (linkOfParent.isEmpty() || findByKey(root, child).isPresent()) {
            return false;
        }
        linkOfParent.get().getChildren().add(new Node<>(child));
        return true;
    }

    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        if (root == null || key == null) {
            throw new IllegalArgumentException();
        }
        Optional<Node<T>> result = Optional.empty();
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        Node<T> currentElement;
        while (stack.getSize() > 0) {
            currentElement = stack.pop();
            if (key.equals(currentElement.getValue())) {
                result = Optional.of(currentElement);
                return result;
            }
            currentElement.getChildren().forEach(stack::push);
        }
        return result;
    }

    public Optional<Node<T>> divideByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        if (root.getValue().equals(key)) {
            return Optional.of(root);
        }
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        Node<T> currentElement;
        while (stack.getSize() > 0) {
            currentElement = stack.pop();
            for (Node<T> currentNode : currentElement.getChildren()) {
                if (currentNode.getValue().equals(key)) {
                    currentElement.getChildren().remove(currentNode);
                    return Optional.of(currentNode);
                }
            }
            currentElement.getChildren().forEach(stack::push);
        }
        return Optional.empty();
    }
}
