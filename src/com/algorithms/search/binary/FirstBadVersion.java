package com.algorithms.search.binary;

/**
 * LeetCode 278. First Bad Version
 * 
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
    
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                if (mid == 1 || !isBadVersion(mid-1)) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                if (mid == n) {
                    return -1;
                } else if (isBadVersion(mid+1)) {
                    return mid + 1;

                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    
    public static boolean isBadVersion(int n) {
        return n >= 1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(4));
    }
}
