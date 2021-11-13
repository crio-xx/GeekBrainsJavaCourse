package ru.gb;

import ru.gb.collections.PriorityQueue;
import ru.gb.collections.linked.LinkedQueue;
import ru.gb.collections.linked.LinkedStack;
import ru.gb.collections.object.ObjectDequeue;
import ru.gb.collections.object.ObjectQueue;
import ru.gb.collections.object.ObjectStack;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> collection = Arrays.asList("one", "two", "three", "four", "five");
        task4_1(collection);
        task4_2(collection);
        task4_3(collection);
        task4_4(collection);
        task4_5(collection);

    }

    static void task4_1(List<String> collection) {
        ObjectStack<String> stack = new ObjectStack<>(collection);
        long start = System.nanoTime();
        stack.pop();
        stack.push("six");
        long end = System.nanoTime();
        System.out.println("Time ObjectStack: " + (end - start));
        System.out.println(stack.toString());
    }

    static void task4_2(List<String> collection) {
        ObjectQueue<String> queue = new ObjectQueue<>(collection);
        long start = System.nanoTime();
        queue.remove();
        queue.push("six");
        long end = System.nanoTime();
        System.out.println("Time ObjectQueue: " + (end - start));
        System.out.println(queue.toString());
    }

    static void task4_3(List<String> collection) {
        ObjectDequeue<String> dequeue = new ObjectDequeue<>(collection);
        long start = System.nanoTime();
        dequeue.removeFirst();
        dequeue.addFirst("zero");
        dequeue.removeLast();
        dequeue.addLast("six");
        long end = System.nanoTime();
        System.out.println("Time ObjectDequeue: " + (end - start));
        System.out.println(dequeue.toString());
    }

    static void task4_4(List<String> collection) {
        PriorityQueue<String> prQueue = new PriorityQueue<>();
        for(var elem: collection) {
            prQueue.add(elem, (int) (Math.random() * collection.size()));
        }
        long start = System.nanoTime();
        prQueue.getMin();
        prQueue.getMax();
        prQueue.add("six", 10);
        prQueue.getMax();
        long end = System.nanoTime();
        System.out.println("Time PriorityQueue: " + (end - start));
        System.out.println(prQueue.toString());
    }

    static void task4_5(List<String> collection) {
        LinkedStack<String> stack = new LinkedStack<>(collection);
        long start = System.nanoTime();
        stack.pop();
        stack.push("six");
        long end = System.nanoTime();
        System.out.println("Time LinkedStack: " + (end - start));
        System.out.println(stack.toString());

        LinkedQueue<String> queue = new LinkedQueue<>(collection);
        start = System.nanoTime();
        queue.remove();
        queue.push("six");
        end = System.nanoTime();
        System.out.println("Time LinkedQueue: " + (end - start));
        System.out.println(queue.toString());
    }

}
