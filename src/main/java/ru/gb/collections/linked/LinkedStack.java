package ru.gb.collections.linked;

import java.util.Collection;

public class LinkedStack<T> extends LinkedList<T> {

    public LinkedStack(Collection<? extends T> collection) {
        super(collection);
    }

    public void push(T elem) {
        storage.addLast(elem);
    }

    public T pop() {
        return   storage.removeLast();
    }
}
