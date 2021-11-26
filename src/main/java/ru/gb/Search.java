package ru.gb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Search {

    public static <T> boolean bfs(Graph<T> graph, T start, T searchTarget) {
        HashSet<T> visitedElements = new HashSet<>();
        LinkedList<T> queue = new LinkedList<>();
        queue.add(start);

        while (queue.size() > 0) {
            var currentElem = queue.removeFirst();
            visitedElements.add(currentElem);
            var children = graph.getChildren(currentElem);
            if(children.contains(searchTarget)) {
                return true;
            }
            children.stream()
                    .filter(i -> !visitedElements.contains(i))
                    .forEach(queue::addLast);
        }
        return false;
    }


    public static <T> boolean dfs(Graph<T> graph, T elem, T searchTarget) {
        return dfs(graph, elem, new HashSet<>(), searchTarget);
    }

    private static <T> boolean dfs(Graph<T> graph, T elem, Set<T> visitedElements, T searchTarget) {
        visitedElements.add(elem);
        if(graph.getChildren(elem).contains(searchTarget)) {
            return true;
        }
        for(var child: graph.getChildren(elem)) {
            if(dfs(graph, child, visitedElements, searchTarget)) {
                return true;
            }
        }
        return false;
    }
}
