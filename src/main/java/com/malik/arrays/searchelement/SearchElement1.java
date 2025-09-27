package com.malik.arrays.searchelement;

public class SearchElement1 {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    static void searchElement(int element) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                System.out.println("Element is present in Array : " +i);
            }
        }
    }
public static void main(String[] args) {
        searchElement(6);
}
}
