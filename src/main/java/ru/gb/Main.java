package ru.gb;

public class Main {

    public static void main(String[] args) {
        var graph1 = new Graph<Integer>();
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 4);
        graph1.addEdge(1, 6);
        graph1.addEdge(2, 8);
        graph1.addEdge(8, 10);

        System.out.println("dfs: " + Search.dfs(graph1, 1, 10));
        System.out.println("dfs: " + Search.dfs(graph1, 1, 11));

        System.out.println("bfs: " + Search.bfs(graph1, 1, 10));
        System.out.println("bfs: " + Search.bfs(graph1, 1, 11));

    }
}
