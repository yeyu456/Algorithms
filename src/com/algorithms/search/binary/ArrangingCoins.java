package com.algorithms.search.binary;

/**
 * LeetCode 441. Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *    n = 5
 *    The coins can form the following rows:
 *    ¤
 *    ¤ ¤
 *    ¤ ¤
 *    Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 *     n = 8
 *     The coins can form the following rows:
 *     ¤
 *     ¤ ¤
 *     ¤ ¤ ¤
 *     ¤ ¤
 *     Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        long start = 1;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long lastStair = mid * (mid - 1) / 2;
            long nextStair = (mid + 1) * mid / 2;
            if (lastStair <= n && nextStair > n) {
                return (int) (mid - 1);
                
            } else if (nextStair == n) {
                return (int) (mid);
                
            } else if (lastStair > n) {
                end = mid - 1;
                
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
    
    public static int arrangeCoins2(int n) {
        return (int) ((Math.sqrt(1 + 8 * ((long)n)) - 1) / 2);
    }

    public static void main(String[] args) {
        for (long i = Integer.MAX_VALUE - 10; i <= Integer.MAX_VALUE; i++) {
            arrangeCoins((int)i);
        }
    }
}
