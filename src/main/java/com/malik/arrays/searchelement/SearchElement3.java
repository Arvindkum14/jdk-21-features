/**
 * 2. Using IntStream (Java 8+)
 * */
package com.malik.arrays.searchelement;

import java.util.stream.IntStream;

public class SearchElement3 {

    static int[] arr = {1,2,3,4,5,6,7,8,9};

    static void searchElement (int element) {
        int index = IntStream.range(0, arr.length)
                .filter(i -> arr[i] == element)
                .findFirst()
                .orElse(-1);

        if (index != -1) {
            System.out.println("Element is present in Array: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
    public static void main(String[] args) {
        searchElement(7);
    }
}
