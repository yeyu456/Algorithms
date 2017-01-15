package com.algorithms.hash;

import java.util.*;

/**
 * LeetCode 349. Intersection of Two Arrays
 *  
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> n1 = new HashSet<>();
        for (int i=0;i<nums1.length;i++) {
            n1.add(nums1[i]);
        }
        Set<Integer> n2 = new HashSet<>();
        for (int i=0;i<nums2.length;i++) {
            if (n1.contains(nums2[i])) {
                n2.add(nums2[i]);
            }
        }
        int size = n2.size();
        int[] results = new int[size];
        int i=0;
        for (Integer v:n2) {
            results[i] = v;
            i++;
        }
        return results;
    }
}
