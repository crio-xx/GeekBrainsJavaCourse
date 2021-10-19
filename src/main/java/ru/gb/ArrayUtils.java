package ru.gb;

import java.util.List;

public class ArrayUtils {

    public static boolean isContainFourAndOne(List<Integer> array) {
        if(array == null) {
            return false;
        }
        return array.contains(1) && array.contains(4);
    }

    public static List<Integer> getSubArrayAfterLastFour(List<Integer> array) {
        if(!array.contains(4)){
            throw new RuntimeException("Array doesn't contain 4");
        }
        var startIndex = Math.min(array.lastIndexOf(4) + 1, array.size());
        return array.subList(startIndex, array.size());
    }

}
