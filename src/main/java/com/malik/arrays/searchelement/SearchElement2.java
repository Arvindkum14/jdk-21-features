/**
 * 1. Using Enhanced For-Loop (for-each)
 * */
package com.malik.arrays.searchelement;

public class SearchElement2 {

    static int[] arr = {1,2,3,4,5,6,7,8,9};
    static void searchElement (int element) {
        int index = 0;
        for (int num : arr) {
            if (num == element) {
                System.out.println("Element is found at index : "+index);
                return;
            }
            index++;
        }
        System.out.println("Element not Found.");
    }
    public static void main(String[] args) {
        searchElement(5);
    }
}
