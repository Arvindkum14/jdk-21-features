/**
 * 3. Number-Increasing Pyramid Pattern
 * Prints a pyramid where each row contains numbers from 1 to the row number.
 * */
package com.malik.commonexamples.printstar;

public class PyramidPatternRight {

    // Function to demonstrate pattern
    public static void printPattern(int num) {
        int i, j;

        // outer loop to handle number of rows
        for (i = 0; i < num; i++) {

            // inner loop to handle number of columns
            for (j = 0; j <= i; j++) {
                // printing column value, upto the row value
                System.out.print(" * ");
            }
            // print new line for each row
            System.out.println();
        }
    }

    // Driver Function
    public static void main(String args[]) {
        printPattern(5);
    }
}
