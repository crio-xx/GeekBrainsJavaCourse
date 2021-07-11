package ru.gb;

import ru.gb.exceptions.MyArraySizeException;
import ru.gb.exceptions.MyArrayDataException;

public class ArrayTools {
    private static final int FIRST_DIM = 4;
    private static final int SECOND_DIM = 4;

    public static int sumAllElements(String[][] array) {
        checkDimensions(array);
        int sum = 0;
        for(int i=0; i < array.length; i++) {
            for(int j=0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(
                            String.format("Element Array[%d][%d]: error casting element to integer", i, j), ex);
                } catch (Exception ex) {
                    throw new MyArrayDataException(
                            String.format("Exception on element Array[%d][%d]", i, j), ex);
                }
            }
        }
        return sum;
    }

    private static void checkDimensions(String [][] array) {
        if(array.length != FIRST_DIM) {
            throw new MyArraySizeException("First dimension is " + array.length +
                    ", but expected " + FIRST_DIM);
        }
        for (var arr: array) {
            if(arr.length != SECOND_DIM) {
                throw new MyArraySizeException("Second dimension is " + array.length +
                        ", but expected " + SECOND_DIM);
            }
        }
    }


}
