/**
 * 4. Using Collections.max() (Used with ArrayList)
 * */
package com.malik.arrays.largestelement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestElement4 {

    public static void main (String[] args) {
        int[] arr = {20, 10, 20, 4, 100};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(Collections.max(list));
    }
}
