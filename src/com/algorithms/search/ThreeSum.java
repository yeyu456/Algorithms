package com.algorithms.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * exercise
 * 1.4.15 part2
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
