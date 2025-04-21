package ru.job4j.newcoll.fortaskavl;

import ru.job4j.newcoll.tree.binarytree.AvlTree;

import java.util.*;

public class TreeAVLMap <T extends Comparable<T>, V> {
    private Node root;

    public boolean contains(T key) {
        return keySet().contains(key);
    }

    public boolean put(T key, V value) {
        return insert(key, value);
    }

    public boolean insert(T key, V value) {
        boolean result = false;
        if (Objects.nonNull(key) && Objects.nonNull(value) && !contains(key)) {
            root = insert(root, key, value);
            result = true;
        }
        return false;
    }


    private Node insert(Node node, T key, V value) {
        Node result = new Node(key, value);
        if (Objects.nonNull(node)) {
            int compareResult = key.compareTo(node.key);
            if (compareResult > 0) {
                node.left = insert(node.left, key, value);
            } else {
                node.right = insert(node.right, key, value);
            }
            updateHeight(node);
            node = balance(node);
        }
        return result;
    }

    private void updateHeight(Node node) {
        int leftNodeHeight = Objects.isNull(node.left) ? -1 : node.left.height;
        int rightNodeHeight = Objects.isNull(node.right) ? -1 : node.right.height;
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node node) {
        Node result = node;
        if (node.balanceFactor < -1) {
            if (node.left.balanceFactor >= 0) {
                result = leftRightCase(node);
            } else {
                result = rightRotation(node);
            }
        } else if (node.balanceFactor > 1) {
            if (node.right.balanceFactor >= 0) {
                result = leftRotation(node);
            } else {
                result = rightLeftCase(node);
            }
        }
        return result;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        updateHeight(newParent);
        updateHeight(node);
        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        updateHeight(newParent);
        updateHeight(node);
        return newParent;
    }

    public boolean remove(T key) {
        // TODO реализуйте метод
        return false;
    }

    public V get(T key) {
        // TODO реализуйте метод
        return null;
    }

    public Set<T> keySet() {
        return inSymmetricalOrder(root, new HashSet<>());
    }

    private Set<T> inSymmetricalOrder(Node node, Set<T> result) {
        if (Objects.nonNull(node)) {
            result = inSymmetricalOrder(node.left, result);
            result.add(node.key);
            result = inSymmetricalOrder(node.right, result);
        }
        return result;
    }

    public Collection<V> values() {
        // TODO реализуйте метод
        return null;
    }

    private class Node {
        private int balanceFactor;
        private T key;
        private V value;
        private int height;
        private Node left;
        private Node right;

        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
