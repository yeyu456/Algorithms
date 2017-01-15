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
 *      and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays2 {
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums1.length;i++) {
            
        }
        int size = 
    }
}
