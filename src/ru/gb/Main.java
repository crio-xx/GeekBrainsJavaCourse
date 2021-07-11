package ru.gb;

import ru.gb.exceptions.MyArraySizeException;
import ru.gb.exceptions.MyArrayDataException;

public class Main {
    public static void main(String[] args) {
        String[][] firstArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] secondArray = {{"1", "a", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] thirdArray = {{"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}};
        var arrays = new String[][][]{firstArray, secondArray, thirdArray};
        for (var array: arrays) {
            try {
                System.out.println((ArrayTools.sumAllElements(array)));
            } catch (MyArraySizeException | MyArrayDataException ex) {
                ex.printStackTrace();
            } finally {
                System.out.println("processing completed...");
            }
        }
    }

}
