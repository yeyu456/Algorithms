package com.algorithms.search;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * Created by yu on 2016/9/8.
 */
public class FourSum {

    public static int get4Sum(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                for (int k = j + 1; k < data.length; k++) {
                    for (int l = k + 1; l < data.length; l++) {
                        if (data[i] + data[j] + data[k] + data[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int get4SumR(int[] data) {
        Arrays.sort(data);
        int count = 0;
        for (int i = 0; i < data.length - 3; i++) {
            if (i != 0 && data[i] == data[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < data.length - 2; j++) {
                if (j != i + 1 && data[j] == data[j - 1])
                    continue;

                int left = j + 1;
                int right = data.length - 1;
                while (left < right) {
                    int sum = data[i] + data[j] + data[left] + data[right];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        count++;
                        left++;
                        right--;
                        while (left < right && data[left] == data[left - 1]) {
                            left++;
                        }
                        while (left < right && data[right] == data[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int fourSumR2(int[] data) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int sum = data[i] + data[j];
                List<Integer> list;
                if (!map.containsKey(sum)) {
                    list = new ArrayList<>();
                    map.put(sum, list);
                } else {
                    list = map.get(sum);
                }
                list.add(i);
                list.add(j);
            }
        }

        Integer[] list = map.keySet().toArray(new Integer[0]);
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            int lowIndex = i;
            int highIndex = list.length - 1;
            List<Integer> curList = map.get(list[i]);
            while(lowIndex <= highIndex) {
                int midIndex = lowIndex + (highIndex - lowIndex) / 2;
                int v = list[i] + list[midIndex];

                if (v > 0) {
                    highIndex = midIndex - 1;

                } else if (v < 0) {
                    lowIndex = midIndex + 1; // +1 和 -1 排除掉已经对比的中值数，减少一次对比

                } else {
                    highIndex--;
                    lowIndex++;
                    List<Integer> midList = map.get(list[midIndex]);
                    for(int j=0;j<midList.size();j+=2) {
                        int m1 = midList.get(j);
                        int m2 = midList.get(j+1);
                        for(int k=0;k<curList.size();k+=2) {
                            int c1 = curList.get(k);
                            int c2 = curList.get(k+1);
                            if (m1 == c1 || m1== c2 || m2 == c1 || m2 == c2) {
                                continue;
                            } else {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
