package com.algorithms.search.binary;

/**
 * LeetCode 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.

 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 * Note:
 * Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;

            } else {
                end = mid;
            }
        }
        if (start == nums.length - 1 || (nums[start] > nums[start + 1])) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 1},
                {1, 3, 4, 0, 2},
                {4, 3, 2, 1, 0},
                {0, 1, 2, 3, 4},
                {5, 6, 1, 3, 4}
        };
        for (int i=0;i<data.length;i++) {
            System.out.println(findPeakElement(data[i]));
        }
    }
}
