/**
 * Using sort function
 * */
package com.malik.arrays.largestelement;

import java.util.Arrays;

public class LargestElement3 {

    public static void main (String[] args) {

        int[] arr = {10, 7, 67, 30, 45, 34, 95, 12};
        Arrays.sort(arr);
        System.out.println("Found the Largest Number : "+arr[arr.length -1]);
    }
}
