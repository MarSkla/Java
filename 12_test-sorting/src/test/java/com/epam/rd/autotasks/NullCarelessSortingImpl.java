package com.epam.rd.autotasks;

import java.util.Arrays;

public class NullCarelessSortingImpl extends Sorting{
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
        System.out.println("THIS IS print FROM \"NullCarelessSortingImpl\"");

    }
}
