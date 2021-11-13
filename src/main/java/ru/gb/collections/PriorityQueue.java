package ru.gb.collections;

import java.util.TreeMap;

public class PriorityQueue<T> {

    TreeMap<Integer,T> storage = new TreeMap<>();

    public void add(T elem, int weight) {
        storage.put(weight, elem);
    }

    public T getMin() {
        return  storage.get(storage.firstKey());
    }

    public T removeMin() {
       return  storage.remove(storage.firstKey());
    }

    public T getMax() {
        return  storage.get(storage.lastKey());
    }

    public T removeMax() {
        return  storage.remove(storage.lastKey());
    }

    public String toString() {
        return storage.toString();
    }

}
