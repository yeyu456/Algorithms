package com.algorithms.search.local;

/**
 * Algorithms 4th exercise 1.4.19 Find Local Minimal Element In Matrix With Distinct Numbers
 * 算法第4版 习题 1.4.19 查找无重复数值矩阵中的局部最小元素
 */
public class MatrixLocalMinSearch {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @return (null:无局部最小元素;其他:某一局部最小元素在数据集的下标序号)
     */
    public static int[] bruteForceSearch(int[][] data) {
        if (data == null || data.length < 3 || data[0].length < 3) {
            throw new IllegalArgumentException("Invalid data matrix.");
        }

        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data[i].length - 1; j++) {
                if (data[i][j] < data[i - 1][j] &&
                        data[i][j] < data[i + 1][j] &&
                        data[i][j] < data[i][j - 1] &&
                        data[i][j] < data[i][j + 1]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 二分搜索实现
     * @param data 数据集
     * @return (null:无局部最小元素;其他:某一局部最小元素在数据集的下标序号)
     */
    public static int[] binarySearch(int[][] data) {
        if (data == null || data.length < 3 || data[0].length < 3) {
            throw new IllegalArgumentException("Invalid data matrix.");
        }

        int start = 0;
        int end = data.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i<data[mid].length;i++) {
                if (data[mid][i] < min) {
                    min = data[mid][i];
                    index = i;
                }
            }
            if (index != -1) {
                if (data[mid][index] < data[mid-1][index] &&
                        data[mid][index] < data[mid+1][index]) {
                    return new int[]{mid, index};

                } else if (data[mid][index] > data[mid-1][index]) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        return null;
    }
}
