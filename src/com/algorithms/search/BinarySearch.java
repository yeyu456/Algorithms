package com.algorithms.search;

import java.util.Arrays;

/**
 * Created by yu on 2016/9/4.
 */
public class BinarySearch {

    public static <T extends Comparable> int search(T key, T[] data) {
        int lowIndex = 0;
        int highIndex = data.length - 1;
        while(lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            int v = key.compareTo(data[midIndex]);

            if (v > 0) {
                lowIndex = midIndex + 1; // +1 和 -1 排除掉已经对比的中值数，减少一次对比
            } else if (v < 0) {
                highIndex = midIndex - 1;

            } else {
                return  midIndex;
            }
        }
        return -1;
    }
}
