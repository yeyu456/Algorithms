package com.algorithms.search.local;


/**
 * Algorithms 4th exercise 1.4.18 Find Local Minimal Element In Array With Distinct Numbers
 * 算法第4版 习题 1.4.18 查找无重复数值数组中的局部最小元素
 */
public class ArrayLocalMinSearch {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @return (-1:无局部最小元素;其他:某一局部最小元素在数据集的下标序号)
     */
    public static int bruteForceSearch(int[] data) {
        if (data == null || data.length < 3) {
            throw new IllegalArgumentException("Invalid data array.");
        }

        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] < data[i - 1] && data[i] < data[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分搜索实现
     * @param data 数据集
     * @return (-1:无局部最小元素;其他:某一局部最小元素在数据集的下标序号)
     */
    public static int binarySearch(int[] data) {
        if (data == null || data.length < 3) {
            throw new IllegalArgumentException("Invalid data array.");
        }

        int start = 0;
        int end = data.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] < data[mid - 1] && data[mid] < data[mid + 1]) {
                return mid;

            } else if (data[mid - 1] < data[mid]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
