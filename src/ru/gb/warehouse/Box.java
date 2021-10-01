package ru.gb.warehouse;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> storage;

    public Box() {
        this.storage = new ArrayList<>();
    }

    public float getWeight() {
        return storage.size() * T.getWeight();
    }

    public <E extends Fruit> boolean compare(Box<E> box) {
        return this.getWeight() > box.getWeight();
    }

    public void pourOut(Box<T> destination) {
        for(var elem: storage) {
            destination.put(elem);
        }
        storage.clear();
    }

    public void put(T element) {
        storage.add(element);
    }
}
