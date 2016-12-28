package com.algorithms.search.binary;

/**
 * LeetCode 50. Pow(x, n)
 *
 * Implement pow(x, n).
 */
public class Pow {

    public static double pow(double x, int n) {
        long absN = (long)n;
        if (absN < 0) {
            absN = -absN;
        }
        double result = 1.0d;
        while (absN > 0) {
            if ((absN & 1) == 1) {
                result *= x;
            }
            x *= x;
            absN >>= 1;
        }
        return n < 0 ? 1 / result : result;
    }
}
