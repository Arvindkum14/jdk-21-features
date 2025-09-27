/**
 * 3. Using Arrays.binarySearch()
 * */
package com.malik.arrays.searchelement;

import java.util.Arrays;

public class SearchElement4 {

    static int[] arr = {1,2,3,4,5,6,7,8,9};

    static void searchElement (int element) {
        int index = Arrays.binarySearch(arr, element);
        if (index >= 0) {
            System.out.println("Element is present in Array: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
    public static void main (String[] args) {
        searchElement(8);
    }
}
