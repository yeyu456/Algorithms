package com.algorithms.search;

import java.util.Arrays;

/**
 * Created by yu on 2016/9/8.
 */
public class FourSum {

    public static int get4Sum(int[] data) {
        int sum = 0;
        for(int i=0;i<data.length;i++) {
            for(int j=i+1;j<data.length;j++) {
                for(int k=j+1;k<data.length;k++) {
                    for(int l=k+1;l<data.length;l++) {
                        if (data[i] + data[j] + data[k] + data[l] == 0) {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static int get4SumR(int[] data) {
        int sum = 0;
        Integer[] pairs = new Integer[data.length * (data.length - 1) / 2];
        int index = 0;
        for(int i=0;i<data.length;i++) {
            for (int j = i + 1; j < data.length; j++) {
                pairs[index] = data[i] + data[j];
                index++;
            }
        }

        Arrays.sort(pairs);
        for(int i=0;i<pairs.length;i++) {
            if (BinarySearch.search(-pairs[i], pairs) != -1) {
                sum++;
            }
        }
        return sum;
    }
}
