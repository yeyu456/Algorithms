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
            throw new IllegalArgumentException("Invalid n");
        }
        long kth = n;
        while (true) {
            long nextStair = kth * (kth + 1) / 2;
            if (nextStair > n) {
                kth >>= 1;

            } else if (nextStair == n) {
                break;

            } else {
                long lastStair = (kth - 1) * kth / 2;
                if (lastStair > n) {
                    kth = lastStair + (nextStair - lastStair) / 2;
                } else if (lastStair == n) {
                    kth += 1;
                    break;
                } else {
                    break;
                }
            }
        }
        return (int) kth;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(3));
    }
}
