package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;


public class SortingTest {

    Sorting sorting = new Sorting();

    @Test (expected = IllegalArgumentException.class)
    public void testNullCase(){
        System.out.println("Start \"Null case test\"");
        int[] arrayNull = null;
        sorting.sort(arrayNull);
        System.out.println("testNullCase: DONE");
    }

    @Test
    public void testEmptyCase(){
        System.out.println("Start \"Empty array test\"");
        int[] expectedEmpty = {};
        int[] emptyArray = {};
        sorting.sort(emptyArray);
        assertArrayEquals(emptyArray, expectedEmpty);
        System.out.println("testEmptyCase: DONE");

    }

    @Test
    public void testSingleElementArrayCase() {
        System.out.println("Start \"Single element array test\"");
        int[] expectedSingle = new int[]{7};
        int[] singleElementArray = new int[]{7};
        sorting.sort(singleElementArray);
        assertArrayEquals(expectedSingle, singleElementArray);
        System.out.println("testSingleElementArrayCase: DONE");

    }

    @Test
    public void testSortedArraysCase() {
        System.out.println("Start \"Already sorted array test\"");
        int[] expectedSortedArray = new int[]{12, 13, 14, 15, 16};
        int[] sortedArray = new int[]{12, 13, 14, 15, 16};
        sorting.sort(sortedArray);
        assertArrayEquals(expectedSortedArray, sortedArray);
        System.out.println("testSortedArraysCase: DONE");

    }

    @Test
    public void testOtherCases() {
        System.out.println("Start \"Other cases test\"");
        int[] expected = new int[]{2, 8, 9, 13, 15};
        int[] toSortArray = new int[]{15, 9, 13, 2, 8};
        sorting.sort(toSortArray);
        assertArrayEquals(expected, toSortArray);
        System.out.println("testOtherCases: DONE");

    }
}