/**
 Left Half Pyramid pattern
 * */
package com.malik.commonexamples.printstar;

public class PyramidPatternLeft {

    public static void printPattern(int num) {

        int i, j;
        for (i = num; i >= 1; i--) {

            // inner loop to print spaces.
            for(j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (j = 0; j <= num - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        printPattern(5);
    }
}
