package ru.gb;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        task1();
        System.out.println("Task 2");
        task2();
        System.out.println("Task 3");
        task3();
        System.out.println("Task 4");
        task4();
        System.out.println("Task 5");
        task5();
        System.out.println("Task 6");
        task6();
    }

    static void task1(){
        /** реализуйте массив на основе существующих примитивных или ссылочных типов данных. */
        MyObject[] myObjects = {new MyObject("text"), new MyObject("sample"), new MyObject("example")};
        /**
         * Выполните обращение к массиву и базовые операции класса Arrays.
         * Оценить выполненные методы с помощью базового класса System.nanoTime().
         */
        long start = System.nanoTime();
        System.out.println(myObjects[1].toString());
        System.out.println( Arrays.hashCode(myObjects));
        System.out.println(Arrays.asList(myObjects));
        System.out.println(Arrays.toString(myObjects));
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));
    }

    static void task2() {
        /** На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск. */
        MyObject someObj = new MyObject("some text");
        MyObject[] myObjects = {new MyObject("text"), new MyObject("sample"), someObj, new MyObject("example")};
        long start = System.nanoTime();
        new Algorithms().linearSearch(myObjects, someObj);
        long end = System.nanoTime();
        System.out.println("Time linear search: " + (end - start));

        start = System.nanoTime();
        new Algorithms().binarySearch(myObjects, someObj, 0, myObjects.length);
        end = System.nanoTime();
        System.out.println("Time binary search: " + (end - start));
    }

    static void task3() {
        int[] array = new int[400];
        for(int i = 0; i < 400; i++) {
            array[i] = (int) (Math.random()*1000);
        }
        long start = System.nanoTime();
        Arrays.sort(array);
        long end = System.nanoTime();
        System.out.println("Time standard sort: " + (end - start));
    }

    static void task4() {
        int[] array = new int[400];
        for(int i = 0; i < 400; i++) {
            array[i] = (int) (Math.random()*1000);
        }
        long start = System.nanoTime();
        Algorithms.bubbleSort(array);
        long end = System.nanoTime();
        System.out.println("Time bubble sort: " + (end - start));
    }

    static void task5() {
        int[] array = new int[400];
        for(int i = 0; i < 400; i++) {
            array[i] = (int) (Math.random()*1000);
        }
        long start = System.nanoTime();
        Algorithms.choiceSort(array);
        long end = System.nanoTime();
        System.out.println("Time choice sort: " + (end - start));
    }

    static void task6() {
        int[] array = new int[400];
        for(int i = 0; i < 400; i++) {
            array[i] = (int) (Math.random()*1000);
        }
        long start = System.nanoTime();
        Algorithms.insertSort(array);
        long end = System.nanoTime();
        System.out.println("Time insert sort: " + (end - start));
    }
}
