package com.algorithms.search.binary;

/**
 * LeetCode 34. Search for a Range
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].

 * For example,
 *  Given [5, 7, 7, 8, 8, 10] and target value 8,
 *  return [3, 4].
 */
public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid array.");
        } else if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        int targetStart = -1;
        int targetEnd = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;

            } else if (target < nums[mid]) {
                end = mid - 1;

            } else {
                if (mid - 1 < 0 || nums[mid-1] != target) {
                    targetStart = mid;
                    start = mid + 1;

                } else if (mid + 1 > nums.length - 1 || nums[mid+1] != target) {
                    targetEnd = mid;
                    end = mid - 1;

                    // while the both sides of mid are equal target,
                    // find the leftmost side index of target first
                } else {
                    targetEnd = mid + 1;
                    end = mid - 1;
                }
            }
        }
        if (targetEnd == -1) {
            targetEnd = targetStart;

        } else {
            start = targetEnd + 1;
            end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target > nums[mid]) {
                    start = mid + 1;

                } else if (target < nums[mid]) {
                    end = mid - 1;

                } else {
                    targetEnd = mid;
                    start = mid + 1;
                }
            }
            if (targetEnd == -1) {
                targetEnd = targetStart;
            }
        }
        return new int[]{targetStart, targetEnd};
    }
}
