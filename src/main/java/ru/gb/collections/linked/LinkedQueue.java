package ru.gb.collections.linked;

import java.util.Collection;

public class LinkedQueue<T> extends LinkedList<T> {

    public LinkedQueue(Collection<? extends T> collection) {
        super(collection);
    }

    public void push(T elem) {
        storage.addLast(elem);
    }

    public T remove() {
        return storage.removeFirst();
    }
}
