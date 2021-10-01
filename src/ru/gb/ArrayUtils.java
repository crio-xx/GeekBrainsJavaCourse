package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtils {
    public static <T> void swap(T[] array, int firstElemIndex, int secondElemIndex){
        var firstElem = array[firstElemIndex];
        array[firstElemIndex] = array[secondElemIndex];
        array[secondElemIndex] = firstElem;
    }

    public static <T> ArrayList<T> convertArrayToArrayList(T[] array){
        ArrayList<T> newArray = new ArrayList<>();
        for(var elem: array) {
            newArray.add(elem);
        }
        return newArray;
    }

    public static <T> ArrayList<T> smartConvertArrayToArrayList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
