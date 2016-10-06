package com.algorithms.search.distance;

import java.util.Arrays;

/**
 * Algorithms 4th exercise 1.4.16 Closest Pair Search Implement
 * 算法第4版 习题 1.4.16 最接近一对查找实现
 */
public class ClosestSearch {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @return 最接近一对的数值
     */
    public static double[] bruteForceSearch(double[] data) {
        if (data == null || data.length < 2) {
            throw new IllegalArgumentException("Invalid data array.");
        } else if (data.length == 2) {
            return data;
        }

        double v1 = Double.MIN_VALUE;
        double v2 = Double.MAX_VALUE;
        double diff = Double.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                double tmpDiff = Math.abs(data[i] - data[j]);
                if (tmpDiff < diff) {
                    diff = tmpDiff;
                    v1 = data[i];
                    v2 = data[j];
                }
            }
        }
        return new double[]{v1, v2};
    }

    /**
     * 双基准快排(Arrays.sort)-线性搜索实现
     * @param data 数据集
     * @return 最接近一对的数值
     */
    public static double[] quickSortSearch(double[] data) {
        if (data == null || data.length < 2) {
            throw new IllegalArgumentException("Invalid data array.");
        } else if (data.length == 2) {
            return data;
        }

        Arrays.sort(data); //TODO repleace self method implement
        double v1 = data[0];
        double v2 = data[1];
        double diff = Math.abs(v1 - v2);
        for (int i = 2; i < data.length; i++) {
            double tmpDiff = Math.abs(data[i] - data[i - 1]);
            if (tmpDiff < diff) {
                diff = tmpDiff;
                v1 = data[i - 1];
                v2 = data[i];
            }
        }
        return new double[]{v1, v2};
    }
}
