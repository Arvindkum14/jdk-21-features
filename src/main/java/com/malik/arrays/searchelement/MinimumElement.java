package com.malik.arrays.searchelement;

public class MinimumElement {

    public static void main(String[] args) {
        int[] arr = {10,324,45,9,9898};
        int minimum = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i] < minimum){
                minimum = arr[i];
            }
        }
        System.out.println(minimum);
    }
}
