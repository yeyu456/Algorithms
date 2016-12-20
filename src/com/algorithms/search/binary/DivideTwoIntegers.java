package com.algorithms.search.binary;

/**
 * LeetCode 29. Divide Two Integers
 *
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        } else if (dividend == 0) {
            return 0;
        } else if (divisor == 0) {
            throw new IllegalArgumentException("Invalid divisor");
        }
        boolean isSameSide = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        long dividendL = (long) dividend;
        if (dividendL < 0L) {
            dividendL = -dividendL;
        }
        long divisorL = (long) divisor;
        if (divisorL < 0L) {
            divisorL = -divisorL;
        }

        long result = 0;
        for (int i = 31; i >= 0 && dividendL != 0; i--) {
            if ((dividendL >> i) >= divisorL) {
                result += 1L << i;
                dividendL -= (divisorL << i);
            }
        }
        if (result == 0) {
            return 0;
        } else {
            result = isSameSide ? result : -result;
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
        }
    }
}
