package com.algorithms.search.binary;

/**
 * LeetCode 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * For example, Consider the following matrix:
 *  [
 *    [1,   3,  5,  7],
 *    [10, 11, 16, 20],
 *    [23, 30, 34, 50]
 *  ]
 *  Given target = 3, return true.
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int hIndex = matrix[0].length - 1;

        int low = 0;
        int high = matrix.length - 1;
        int start = 0;
        int end = matrix[0].length - 1;

        while (start <= end && low <= high) {
            int mid = start + (end - start) / 2;
            int med = low + (high - low) / 2;
            if (matrix[med][mid] == target) {
                return true;

            } else if (matrix[med][mid] < target) {
                if (matrix[med][hIndex] == target) {
                    return true;

                } else if (matrix[med][hIndex] > target) {
                    start = mid + 1;

                } else {
                    low = med + 1;
                }

            } else {
                if (matrix[med][0] == target) {
                    return true;

                } else if (matrix[med][0] < target) {
                    end = mid - 1;

                } else {
                    high = med - 1;
                }
            }
        }
        return false;
    }
}
