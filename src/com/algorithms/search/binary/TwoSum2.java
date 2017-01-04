package com.algorithms.search.binary;

/**
 * LeetCode 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum2 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2 || nums[0] > target) {
            return new int[]{-1, -1};
        }
        for(int i=0;i<nums.length-1;i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int v = target - nums[i];
            if (nums[start] <= v && v <= nums[end]) {
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] == v) {
                        return new int[]{i+1, mid+1};
                    } else if (nums[mid] < v) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {2, 7, 11, 15}, {9}
        };
        for(int i=0;i<data.length;i+=2) {
            int[] result = twoSum(data[i], data[i+1][0]);
            System.out.println(result[0] + "," + result[1]);
        }
    }
}
