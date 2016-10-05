package com.algorithms.search.nsum;

import java.util.HashSet;
import java.util.Set;


/**
 * Algorithms 4th exercise 1.4.15-part1  2-Sum Count Of Unique Element Set In Sorted Array
 * 算法第4版 习题 1.4.15第一部分 统计排序好数组中，2个元素之和为0的非重复整数集的数量
 */
public class TwoSum {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @return 数量
     */
    public static int bruteForceSearch(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] + data[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int twoSumR2(int[] data) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            if (!set.contains(data[i])) {
                set.add(data[i]);
                if (set.contains(-data[i])) {
                    count++;
                }
            }
        }
        return count;
    }
}
