package com.algorithms.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuye on 2016/9/15.
 */
public class TwoSum {

    public static int twoSumR1(int[] data) {
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
