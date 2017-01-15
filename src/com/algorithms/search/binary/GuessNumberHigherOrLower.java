package com.algorithms.search.binary;

/**
 * LeetCode 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *    -1 : My number is lower
 *     1 : My number is higher
 *     0 : Congrats! You got it!
 *
 * Example:
 *     n = 10, I pick 6.
 *     Return 6.
 */
public class GuessNumberHigherOrLower {

    public static int guessNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid n");
        }
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int guessResult = guess(mid);
            switch (guessResult) {
                case -1:
                    end = mid - 1;
                    break;

                case 0:
                    return mid;

                case 1:
                    start = mid + 1;
                    break;

                default:
                    throw new IllegalStateException("Shouldn't be happened.");
            }
        }
        throw new IllegalStateException("Shouldn't be happened.");
    }

    public static int guess(int num) {
        return 0;
    }
}
