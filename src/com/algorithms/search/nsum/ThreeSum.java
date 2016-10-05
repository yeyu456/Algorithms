package com.algorithms.search.nsum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Algorithms 4th exercise 1.4.15-part2  3-Sum Count Of Unique Element Set In Sorted Array
 * 算法第4版 习题 1.4.15第二部分 统计排序好的数组中，3个元素之和为0的非重复整数集的数量
 */
public class ThreeSum {

    public static int threeSumR1(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                for (int k = j + 1; k < data.length; k++) {
                    if (data[i] + data[j] + data[k] == 0) {
                        //System.out.println("r1 " + data[i]  + " " +  data[j]  + " " +  data[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int threeSumR2(int[] data) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int sum = data[i] + data[j];
                if (set.contains(-sum)) {
                    //System.out.println("r1 " + data[i]  + " " +  data[j]  + " " +  -sum);
                    count++;
                }
            }
            set.add(data[i]);
        }
        return count;
    }
}
