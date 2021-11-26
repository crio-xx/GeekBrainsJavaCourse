package ru.gb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Graph<T> {

    HashMap<T, ArrayList<T>> relatedList = new HashMap<>();

    void addEdge(T from, T to) {
        if(!relatedList.containsKey(from)) {
            addVertex(from);
        }
        relatedList.get(from).add(to);
    }

    void addVertex(T from) {
        relatedList.put(from, new ArrayList<>());
    }

    public void removeEdge(T from, T to) {
        relatedList.get(from).remove(to);
    }

    public void removeVertex(T from) {
        relatedList.remove(from);
    }

    public ArrayList<T> getChildren(T from) {
        var children = relatedList.get(from);
        return Objects.requireNonNullElseGet(children, ArrayList::new);
    }

}
