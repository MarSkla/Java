package com.epam.rd.autotasks;

class CycleSwap {

    static void cycleSwap(int[] array) {
        if (array.length != 0) {
            for (int i = 0; i < 1; i++) {
                int last = array[array.length - 1];
                System.arraycopy(array, 0, array, 1, array.length - 1);
                array[0] = last;
            }
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length != 0) {
            for (int i = 0; i < shift; i++) {
                int last = array[array.length - 1];
                System.arraycopy(array, 0, array, 1, array.length - 1);
                array[0] = last;
            }
        }
    }
}
