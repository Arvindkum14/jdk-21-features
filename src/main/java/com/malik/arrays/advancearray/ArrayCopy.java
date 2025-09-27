package com.malik.arrays.advancearray;

public class ArrayCopy {

    static int[] arrA = {2, 5, 6, 1, 8};
    static void copyArrays () {
        int[] arrB = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            arrB[i] = arrA[i];
        }
        arrB[0]++;
        System.out.print("arrA: ");
        for (int i = 0; i < arrA.length; i++) {
            System.out.print(arrA[i] + " ");
        }

        System.out.println();

        System.out.print("arrB: ");
        for (int i = 0; i < arrB.length; i++) {
            System.out.print(arrB[i] + " ");
        }
    }
    public static void main (String[] args) {
        copyArrays();
    }
}
