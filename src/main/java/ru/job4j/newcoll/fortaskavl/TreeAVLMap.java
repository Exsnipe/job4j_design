package ru.job4j.newcoll.fortaskavl;

import ru.job4j.newcoll.tree.binarytree.AvlTree;
import ru.job4j.newcoll.tree.binarytree.PrintTree;
import ru.job4j.newcoll.tree.binarytree.VisualNode;

import java.util.*;

public class TreeAVLMap<T extends Comparable<T>, V> {
    private Node root;

    public boolean contains(T key) {
        return keySet().contains(key);
    }

    public boolean put(T key, V value) {
        return insert(key, value);
    }

    public boolean insert(T key, V value) {
        boolean result = false;
        if (Objects.nonNull(key) && Objects.nonNull(value)) {
            root = insert(root, key, value);
            result = true;
        }
        return result;
    }

    private Node insert(Node node, T key, V value) {
        Node result = new Node(key, value);
        if (Objects.nonNull(node)) {
            int compareResult = key.compareTo(node.key);
            if (compareResult == 0) {
                node.value = value;
                return node;
            }
            if (compareResult < 0) {
                node.left = insert(node.left, key, value);
            } else {
                node.right = insert(node.right, key, value);
            }
            updateHeight(node);
            result = balance(node);
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
        boolean result = false;
        if (Objects.nonNull(key) && Objects.nonNull(root) && contains(key)) {
            root = remove(root, key);
            result = true;
        }
        return result;
    }

    private Node remove(Node node, T key) {
        if (node == null) {
            return null;
        }
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult < 0) {
            node.left = remove(node.left, key);
        } else if (comparisonResult > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.left.height > node.right.height) {
                    T heir = maximum(node.left).key;
                    node.key = heir;
                    node.left = remove(node.left, heir);
                } else {
                    T heir = minimum(node.right).key;
                    node.key = heir;
                    node.right = remove(node.right, heir);
                }
            }
        }
        updateHeight(node);
        return balance(node);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public V get(T key) {
        if (root == null || key == null || !contains(key)) {
            return null;
        }
        return get(root, key);
    }

    private V get(Node node, T key) {
        V result = null;
        int compareKey = key.compareTo(node.key);
        if (compareKey == 0) {
            return node.value;
        }
        if (compareKey > 0) {
            result = get(node.right, key);
        } else {
            result = get(node.left, key);
        }
        return result;
    }

    public Set<T> keySet() {
        Set<T> result = new HashSet<>();
        return keysInSymmetricalOrder(root, result);
    }

    private Set<T> keysInSymmetricalOrder(Node node, Set<T> result) {
        if (Objects.nonNull(node)) {
            result = keysInSymmetricalOrder(node.left, result);
            result.add(node.key);
            result = keysInSymmetricalOrder(node.right, result);
        }
        return result;
    }

    public Collection<V> values() {
        Collection<V> result = new ArrayList<>();
        return valuesInSymmetricalOrder(root, result);
    }

    private Collection<V> valuesInSymmetricalOrder(Node node, Collection<V> result) {
        if (Objects.nonNull(node)) {
            result = valuesInSymmetricalOrder(node.left, result);
            result.add(node.value);
            result = valuesInSymmetricalOrder(node.right, result);
        }
        return result;
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode {
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

        @Override
        public VisualNode getLeft() {
            return left;
        }

        @Override
        public VisualNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return String.valueOf(key);
        }
    }
}
