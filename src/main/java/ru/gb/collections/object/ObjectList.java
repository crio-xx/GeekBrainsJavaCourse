package ru.gb.collections.object;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectList<T> {

    List<T> storage = new ArrayList<>();

    ObjectList(Collection<? extends T> collection) {
        storage.addAll(collection);
    }

    public String toString() {
        return storage.toString();
    }
}
