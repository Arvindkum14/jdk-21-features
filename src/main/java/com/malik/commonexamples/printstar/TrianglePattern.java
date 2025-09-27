package com.malik.commonexamples.printstar;

public class TrianglePattern {

    public static void printPattern(int n) {
        int i, j;

// loop to iterate for the given number of rows
        for (i = 1; i <= n; i++) {
            // loop to print the number of spaces before the star
            for (j = n; j >= i; j--) {
                System.out.print(" ");
            }
            // loop to print the number of stars in each row
            for (j =1; j<= i; j++) {
                System.out.print("* ");
            }
            // for new line after printing each row
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printPattern(6);
    }
}
