package ru.gb;

public class Algorithms {

    public <T extends MyObject> int linearSearch(T[] array, T obj) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].getKey().equals(obj.getKey())) {
                return i;
            }
        }
        return array.length;
    }

    public <T extends MyObject> int binarySearch(T[] sortedArray, T obj, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArray[mid].getKey().compareTo(obj.getKey()) < 0) {
                low = mid + 1;
            } else if (sortedArray[mid].getKey().compareTo(obj.getKey()) > 0) {
                high = mid - 1;
            } else if (sortedArray[mid].getKey().equals(obj.getKey())) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
    }

    public static void choiceSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }

    public static void insertSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }

}
