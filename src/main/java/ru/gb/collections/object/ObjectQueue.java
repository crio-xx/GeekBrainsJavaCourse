package ru.gb.collections.object;

import java.util.Collection;

public class ObjectQueue<T> extends ObjectList<T> {

    public ObjectQueue(Collection<? extends T> collection) {
        super(collection);
    }

    public void push(T elem) {
        storage.add(storage.size(), elem);
    }

    public T remove() {
        return storage.remove(0);
    }
}
