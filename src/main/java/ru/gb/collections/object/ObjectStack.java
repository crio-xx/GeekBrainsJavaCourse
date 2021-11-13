package ru.gb.collections.object;

import java.util.Collection;

public class ObjectStack<T> extends ObjectList<T> {

    public ObjectStack(Collection<? extends T> collection) {
        super(collection);
    }

    public void push(T elem) {
        storage.add(elem);
    }

    public T pop() {
        return storage.remove(storage.size() - 1);
    }
}
