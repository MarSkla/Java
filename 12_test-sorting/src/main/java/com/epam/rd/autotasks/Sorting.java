package com.epam.rd.autotasks;

import java.util.Arrays;

public class Sorting {
    public void sort(int[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        } else {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = i + 1; j < array.length; j++) {
//                    int temporary = 0;
//                    if (array[i] > array[j]) {
//                        temporary = array[i];
//                        array[i] = array[j];
//                        array[j] = temporary;
//                    }
//                }
//            }
            Arrays.sort(array);
        }
    }
}
