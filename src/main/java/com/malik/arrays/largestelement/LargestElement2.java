/**
 * Java 8 Stream
 * */
package com.malik.arrays.largestelement;

import java.util.Arrays;

public class LargestElement2 {

    public static void main(String[] args)
    {
        int[] arr = {20, 10, 20, 4, 100};

        // Java Stream and max to find the
        // max element in array
        int max = Arrays.stream(arr).max().getAsInt();

        System.out.println(max);
    }
}
