/**
 * 1. Using Collections.reverseOrder()
 * */
package com.malik.arrays.searchingsorting;

import java.util.Arrays;
import java.util.Collections;

public class DescArrays {

    public static void main(String[] args)
    {
        Integer a[] = { 1, 2, 3, 4, 5 };

        // Sorting the array in descending order
        Arrays.sort(a, Collections.reverseOrder());

        System.out.println(Arrays.toString(a));
    }
}
