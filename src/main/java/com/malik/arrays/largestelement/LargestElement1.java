/**
 *Iterative Approach
 * */
package com.malik.arrays.largestelement;

public class LargestElement1 {

    static int[] arr = {1,2,7,3,9,5,8};

    static void findLargest () {
        int max = arr[0];
        for (int i = 0; i < arr.length;  i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("The Largest Number is : "+max);
    }
    public static void main (String[] args) {
        findLargest();
    }
}
