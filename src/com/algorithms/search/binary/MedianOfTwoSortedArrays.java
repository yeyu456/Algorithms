package com.algorithms.search.binary;

/**
 * LeetCode 4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *  nums1 = [1, 3]
 *  nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    private static double getMedian(int[] n){
        int mid = n.length / 2;
        if (n.length % 2 == 1) {
            return n[mid];
        } else {
            return (n[mid] + n[mid - 1]) / 2.0d;
        }
    }

    public static double findMedianSortedArrays(int[] n1, int[] n2) {
        if (n1 == null || n2 == null || (n1.length == 0 && n2.length == 0)) {
            throw new IllegalArgumentException("Null parameter");

        } else if (n1.length == 0) {
            return getMedian(n2);

        } else if (n2.length == 0) {
            return  getMedian(n1);
        }
        if (n1.length > n2.length) {
            int[] tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        int iMin = 0;
        int iMax = n1.length;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (n1.length + n2.length + 1) / 2 - i;
            if (i < n1.length && n2[j-1] > n1[i]) {
                iMin = i + 1;

            } else if (i > 0 && n1[i-1] > n2[j]) {
                iMax = i - 1;

            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = n2[j-1];
                } else if (j == 0) {
                    maxLeft = n1[i-1];
                } else if (n2[j-1] <= n1[i-1]) {
                    maxLeft = n1[i-1];
                } else {
                    maxLeft = n2[j-1];
                }

                if ((n1.length + n2.length) % 2 == 1) {
                    return  maxLeft;
                }

                int minRight;
                if (i == n1.length) {
                    minRight = n2[j];
                } else if (j == n2.length) {
                    minRight = n1[i];
                } else if (n1[i] <= n2[j]) {
                    minRight = n1[i];
                } else {
                    minRight = n2[j];
                }
                return (minRight + maxLeft) / 2.0d;
            }
        }
        throw new IllegalArgumentException("Cannot find median");
    }
}
