package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int[][] result = new int[rows][columns];
        int start = 1;

        int firstRow = 0, lastRow = rows-1;
        int firstColumn = 0, lastColumn = columns-1;

        while (start <= rows*columns) {
            for (int i = firstColumn; i <= lastColumn; i++) {
                result[firstRow][i] = start;
                System.out.println("current value: " + result[firstRow][i]);
                start++;
            }

            if (start <= rows * columns) {
                for (int i = firstRow+1; i <= lastRow; i++) {
                    result[i][lastColumn] = start;
                    System.out.println("current value: " + result[i][lastColumn]);
                    start++;
                }
            } else {
                break;
            }

            for (int i = lastColumn-1; i >= firstColumn; i--) {
                result[lastRow][i] = start;
                System.out.println("current value: " + result[lastRow][i]);
                start++;
            }

            for (int i = lastRow-1; i >= firstRow+1; i--) {
                result[i][firstColumn] = start;
                System.out.println("current value: " + result[i][firstColumn]);
                start++;
            }

            firstColumn++;
            firstRow++;

            lastColumn--;
            lastRow--;
        }

        return result;
    }
}
