package ru.job4j.collection.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        int elementSize = evenElements.size();
        for (int index = 0; index < elementSize; index++) {
            if (index % 2 == 0) {
                result.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return result.toString();
    }

    private String getDescendingElements() {
       StringBuilder result = new StringBuilder();
        while (!descendingElements.isEmpty()) {
            result.append(descendingElements.pollLast());
        }
       return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
