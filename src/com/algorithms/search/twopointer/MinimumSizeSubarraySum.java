package com.algorithms.search.twopointer;

/**
 * LeetCode 209. Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * If you have figured out the O(n) solution,
 * try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = nums.length + 1;

        while (right < nums.length) {
            sum += nums[right];
            right++;
            if (sum >= s) {
                while (sum - nums[left] >= s) {
                    sum -= nums[left];
                    left++;
                }
                if (right - left < minLen) {
                    minLen = right - left;
                }
            }
        }
        return minLen > nums.length ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[][] data = {
                {2,3,1,2,4,3}, {7},
                {1}, {2},
                {1,2,3,4}, {10},
                {1,2,3,4}, {11},
                {7, 7, 7}, {7}
        };
        for(int i=0;i<data.length;i+=2) {
            System.out.println(minSubArrayLen(data[i+1][0], data[i]));
        }
    }
}
