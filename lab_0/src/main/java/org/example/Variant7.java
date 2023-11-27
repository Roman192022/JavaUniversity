package org.example;

public class Variant7 {

    /**
     *
     * @param num is a two-digit number
     * @return an array of the sum and product of the digits
     * @throws IllegalArgumentException if the number is not a two-digit positive number
     */

    public static int[] integerTask(int num) {
        if (num > 99 || num < 10) {
            throw new IllegalArgumentException("Argument must be a 2-digit positive number!");
        }

        int dig_1 = num / 10;
        int dig_2 = num % 10;

        return new int[] {dig_1 + dig_2, dig_1 * dig_2};
    }


    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @param c is integer number
     * @return true, if number b is between numbers a and c
     */

    public static boolean booleanTask(int a, int b, int c) {
        return (b > a) && (b < c);
    }


    /**
     *
     * @param a is float number
     * @param b is float number
     * @return ordinal number of the smaller number
     */

    public static int ifTask(float a, float b) {
        if (a < b) return 1;
        return 2;
    }


    /**
     *
     * @param n is number between 1 and 5
     * @param mass is weight in certain units
     * @return weight in specified units
     * @throws IllegalArgumentException if N is not a number between 1 and 5
     * @throws IllegalArgumentException if Mass number is not a a non-negative float number
     */

    public static float caseTask(int n, float mass) {

        if ((n < 0) || (n > 5)) {
            throw new IllegalArgumentException("'N' must be a number between 1 and 5!");
        }

        if (mass < 0) {
            throw new IllegalArgumentException("'Mass' must be a non-negative float number!");
        }

        switch (n) {
            case 2:
                return mass / 1000000;
            case 3:
                return mass / 1000;
            case 4:
                return mass * 1000;
            case 5:
                return mass * 100;
            default:
                return mass;
        }
    }


    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @return sum of integers from a to b inclusive
     */

    public static double forTask(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++)
            sum += i;
        return sum;
    }


    /**
     *
     * @param n is integer number
     * @return the smallest integer which square is greater than n
     * throws IllegalArgumentException if argument is not an integer positive number
     */

    public static int whileTask(int n) {

        if ((n < 0) || (n != ( (int)n ) )) {
            throw new IllegalArgumentException("Argument must be an integer positive number!");
        }

        int k = 2;
        while (k * k <= n) {
            k++;
        }

        return k;
    }


    /**
     *
     * @param n is integer number
     * @param arr is an array of n elements
     * @return numbers of the first maximum and last minimum element from a given set
     * @throws IllegalArgumentException if the array length is less than 2
     */

    public static int[] minMaxTask(int n, int[] arr) {

        if (n < 2 || arr.length < 2) {
            throw new IllegalArgumentException("Array length must be at least 2!");
        }

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            } else if (arr[i] <= arr[minIndex]) {
                minIndex = i;
            }
        }

        return new int[] {maxIndex, minIndex};
    }

    /**
     *
     * @param n is an integer number
     * @param arr is array of n elements
     * @throws IllegalArgumentException if n is incorrect
     */

    // print the array in reverse order
    public static void arrayTask(int n, float[] arr) {
        if (n <= 0 || n > arr.length) {
            throw new IllegalArgumentException("Invalid value for n!");
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     *
     * @param matrix is a matrix of integers
     * @param n is an integer number
     * @param m is an integer number
     * @param k is an integer number
     * @throws IllegalArgumentException if matrix dimensions are invalid or k is out of bounds
     */

    // print the elements of the k-th row of the matrix.
    public static void matrixTask(int[][] matrix, int n, int m, int k) {

        if (k < 0 || k >= n || m <= 0) {
            throw new IllegalArgumentException("Invalid values for dimensions or k!");
        }

        for (int i = 0; i < matrix[k].length; i++) {
            System.out.print(matrix[k][i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Start of zero lab.");
        System.out.println("Done!");
    }
}
