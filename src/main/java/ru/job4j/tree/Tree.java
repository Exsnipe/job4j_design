package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Tree<E> {
    boolean isBinary();
    boolean add(E parent, E child);
    Optional<Node<E>> findBy(E vale);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
