package ru.job4j.queue;

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
        StringBuilder str = new StringBuilder();
        int size = evenElements.size() / 2;
        for (int i = 0; i < size; i++) {
            str.append(evenElements.poll());
            evenElements.poll();
        }
        return String.valueOf(str);
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        Iterator iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            str.append(iterator.next());
        }
        return String.valueOf(str);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}