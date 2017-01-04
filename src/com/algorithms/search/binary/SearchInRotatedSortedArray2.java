package com.algorithms.search.binary;

/**
 * LeetCode 81. Search in Rotated Sorted Array II
 *
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArray2 {

    public static boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return true;

            } else if (nums[start] < nums[mid]) { //left half is sorted
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[start] > nums[mid]) { //right half is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start++;
            }
        }
        return false;
    }
}
