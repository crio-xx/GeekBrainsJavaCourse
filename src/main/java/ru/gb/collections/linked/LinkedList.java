package ru.gb.collections.linked;

import java.util.Collection;

public class LinkedList<T> {

    java.util.LinkedList<T> storage = new java.util.LinkedList<>();;

    LinkedList(Collection<? extends T> collection) {
        storage.addAll(collection);
    }

    public String toString() {
        return storage.toString();
    }
}
