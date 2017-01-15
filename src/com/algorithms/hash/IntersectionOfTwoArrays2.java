package com.algorithms.hash;

import java.util.*;

/**
 * LeetCode 350. Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 *      What if the given array is already sorted? How would you optimize your algorithm?
 *      What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *      What if elements of nums2 are stored on disk, 
 *      and the memory is limited such that you cannot load all elements into the memory at once? TODO
 */
public class IntersectionOfTwoArrays2 {
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] results = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int index1 = 0;
        int index2 = 0;
        int indexR = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                results[indexR] = nums1[index1];
                index1++;
                index2++;
                indexR++;
            }
        }
        if (indexR == results.length) {
            return results;

        } else if (indexR == 0) {
            return new int[0];

        } else {
            return Arrays.copyOf(results, indexR);
        }
    }
}
