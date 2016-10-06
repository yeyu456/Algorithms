package com.algorithms.search.nsum;

import java.util.HashSet;
import java.util.Set;


/**
 * Algorithms 4th exercise 1.4.15-part2  3-Sum Count Of Unique Element Set In Sorted Array
 * 算法第4版 习题 1.4.15第二部分 统计排序好的数组中，3个元素之和为0的整数集的数量
 */
public class ThreeSum {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @return 数量
     */
    public static int bruteForceSearch(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                for (int k = j + 1; k < data.length; k++) {
                    if (data[i] + data[j] + data[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 哈希搜索实现
     * @param data 数据集
     * @return 数量
     */
    public static int hashSearch(int[] data) {
        int count = 0;
        Set<Integer> set = new HashSet<>(); //TODO replace hash set with self implement
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int sum = data[i] + data[j];
                if (set.contains(-sum)) {
                    count++;
                }
            }
            set.add(data[i]);
        }
        return count;
    }
}
