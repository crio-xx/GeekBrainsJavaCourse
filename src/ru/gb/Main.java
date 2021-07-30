package ru.gb;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {

        timeMeasurementOneThread();
        timeMeasurementTwoThread();
    }

    public static void timeMeasurementOneThread() {

        float[] arr = getFilledArray();
        long timeStart = System.currentTimeMillis();
        calculateNewValues(arr);
        long timeEnd = System.currentTimeMillis();
        System.out.println("One thread: " + (timeEnd - timeStart));
    }

    public static void timeMeasurementTwoThread() throws InterruptedException {

        float[] arr = getFilledArray();
        float[] firstPartArr = new float[h];
        float[] secondPartArr = new float[h];
        long timeStart = System.currentTimeMillis();
        // разделение массива на две части
        System.arraycopy(arr, 0, firstPartArr, 0, h);
        System.arraycopy(arr, 0, secondPartArr, 0, h);
        Thread t1 = new Thread(() ->
                calculateNewValues(firstPartArr));
        t1.start();
        Thread t2 = new Thread(() ->
                calculateNewValues(secondPartArr));
        t2.start();
        t1.join();
        t2.join();
        // склейка двух частей массива
        System.arraycopy(firstPartArr, 0, arr, 0, h);
        System.arraycopy(secondPartArr, 0, arr, h, h);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Two thread: " + (timeEnd - timeStart));
    }

    public static float[] getFilledArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1F);
        return arr;
    }

    public static void calculateNewValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
