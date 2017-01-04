package com.algorithms.search.binary;

/**
 * LeetCode 154. Find Minimum in Rotated Sorted Array II
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArray2 {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) {
                start = mid + 1;

            } else if (nums[start] > nums[mid]) {
                end = mid;

            } else {
                start++;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[][] data = {
                {2,3, 4, 5, 6, 0, 1,},
                {5,1,2,3,4},
                {1,2,3,4,5},
                {4,5,6,1,2,3},
                {2, 1},
                {1, 1},
                {1,2,1},
                {1,1,2,1},
                {1,2,2,1},
                {1,2,3,3,1},
                {2, 1,1,1,1},
                {2,1,2,2,2}
        };
        for(int i=0;i<data.length;i++) {
            System.out.println(findMin(data[i]));
        }
    }

}
