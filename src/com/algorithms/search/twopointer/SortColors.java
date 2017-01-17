package com.algorithms.search.twopointer;

/**
 * LeetCode 75. Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int pre = 0;
        int color = 0;
        while (pre < nums.length && color <= 2) {
            for (int cur=pre;cur<nums.length;cur++) {
                if (nums[cur] == color) {
                    int tmp = nums[pre];
                    nums[pre] = nums[cur];
                    nums[cur] = tmp;
                    pre++;
                }
            }
            color++;
        }
    }

    public static void main(String[] args) {
        int[] data = {1,1,1,1,1,2};
        sortColors(data);
        for (int i=0;i<data.length;i++) {
            System.out.println(data[i]);
        }
    }
}
