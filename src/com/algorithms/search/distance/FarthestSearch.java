package com.algorithms.search.distance;

/**
 * Algorithms 4th exercise 1.4.17 Farthest Pair Search Implement
 * 算法第4版 习题 1.4.17 最遥远一对查找实现
 */
public class FarthestSearch {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @return 最遥远一对的数值
     */
    public static double[] bruteForceSearch(double[] data) {
        if (data == null || data.length < 2) {
            throw new IllegalArgumentException("Invalid data array.");
        } else if (data.length == 2) {
            return data;
        }

        double v1 = 0.0;
        double v2 = 0.0;
        double diff = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                double tmpDiff = Math.abs(data[i] - data[j]);
                if (tmpDiff > diff) {
                    diff = tmpDiff;
                    v1 = data[i];
                    v2 = data[j];
                }
            }
        }
        return new double[]{v1, v2};
    }

    /**
     * 线性搜索实现
     * @param data 数据集
     * @return 最遥远一对的数值
     */
    public static double[] linearSearch(double[] data) {
        if (data == null || data.length < 2) {
            throw new IllegalArgumentException("Invalid data array.");
        } else if (data.length == 2) {
            return data;
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 2; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (data[i] > max) {
                max = data[i];
            }
        }
        return new double[]{min, max};
    }
}
