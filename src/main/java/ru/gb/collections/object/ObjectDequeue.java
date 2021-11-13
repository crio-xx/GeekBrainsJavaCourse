package ru.gb.collections.object;

import java.util.Collection;

public class ObjectDequeue<T> extends ObjectList<T> {
    public ObjectDequeue(Collection<? extends T> collection) {
        super(collection);
    }

    public void addFirst(T elem) {
        storage.add(0, elem);
    }

    public void addLast(T elem) {
        storage.add(storage.size(), elem);
    }

    public T removeFirst() {
        return storage.remove(0);
    }

    public T removeLast() {
        return storage.remove(storage.size() - 1);
    }
}
