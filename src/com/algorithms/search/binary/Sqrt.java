package com.algorithms.search.binary;

/**
 * LeetCode 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class Sqrt {

    public static int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long start = 1;
        long end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long pow = mid * mid;
            long powplus = (mid + 1) * (mid + 1);
            if (pow <= x && (powplus > x)) {
                return (int) mid;

            } else if (powplus == x) {
               return (int) mid + 1;

            } else if (pow > x) {
                end = mid;

            } else if (powplus < x) {
                start = mid;
            }
        }
        throw new IllegalArgumentException("Cannot find sqrt.");
    }
}
