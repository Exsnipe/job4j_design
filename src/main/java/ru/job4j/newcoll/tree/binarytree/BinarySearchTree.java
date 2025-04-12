package ru.job4j.newcoll.tree.binarytree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public boolean put(T key) {
        boolean result;
        if (Objects.isNull(root)) {
            root = new Node(key);
            result = true;
        } else {
            result = put(root, key);
        }
        return result;
    }

    private boolean put(Node node, T key) {
        if (node.key.equals(key)) {
            return false;
        }
        if (node.key.compareTo(key) > 0) {
            if (node.left == null) {
                node.left = new Node(key);
                return true;
            }
            put(node.left, key);
        } else {
            if (node.right == null) {
                node.right = new Node(key);
                return true;
            }
            put(node.right, key);
        }
        return false;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    private Node find(Node node, T key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            find(node.right, key);
        } else {
            find(node.left, key);
        }
        return null;
    }

    public boolean remove(T key) {
        /* Метод будет реализован в следующих уроках */
        return false;
    }

    public List<T> inSymmetricalOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inSymmetricalOrder(node, result);
    }

    private List<T> inSymmetricalOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPreOrder() {
        //TODO реализуйте метод
        return null;
    }

    private List<T> inPreOrder(Node localRoot, List<T> list) {
        //TODO реализуйте метод
        return null;
    }

    public List<T> inPostOrder() {
        //TODO реализуйте метод
        return null;
    }

    private List<T> inPostOrder(Node localRoot, List<T> list) {
        //TODO реализуйте метод
        return null;
    }

    public T minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        //TODO реализуйте метод
        return null;
    }

    public T maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        //TODO реализуйте метод
        return null;
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
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
            return key.toString();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.put("first");
        tree.put("second");
        tree.put("third");
        System.out.println(tree);
        System.out.println(tree.find(tree.root, "second").key);
        System.out.println(tree.contains("third"));
    }
}
