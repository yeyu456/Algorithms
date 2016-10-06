package com.algorithms.search.nsum;

import java.util.*;

/**
 * Algorithms 4th exercise 1.4.14 4-Sum Count Of Unique Element Set In Sorted Array
 * 算法第4版 习题 1.4.14 统计排序好的数组中，4个元素之和为0的整数集的数量
 */
public class FourSum {

    /**
     * 暴力搜索实现
     *
     * @param data 数据集
     * @return 数量
     */
    public static int bruteForceSearch(int[] data) {
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

    /**
     * 暴力搜索结合双指针线性搜索
     *
     * @param data 数据集
     * @return 数量
     */
    public static int bruteForceWithDoublePointerSearch(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length - 3; i++) {
            if (i != 0 && data[i] == data[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < data.length - 2; j++) {
                if (j != i + 1 && data[j] == data[j - 1]) {
                    continue;
                }
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

    /**
     * 哈希搜索
     *
     * @param data 数据集
     * @return 数量
     */
    public static int hashSearch(int[] data) {
        int count = 0;
        Map<Integer, List<Integer>> map = FourSum.getHashMap(data);
        Set<Integer> hash = new HashSet<>();
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() < 4) {
                continue;
            }
            for (int i = 0; i < list.size(); i += 2) {
                for (int j = i + 2; j < list.size(); j += 2) {
                    int i1 = list.get(i);
                    int i2 = list.get(i + 1);
                    int j1 = list.get(j);
                    int j2 = list.get(j + 1);
                    if (i1 == j1 || i1 == j2 || i2 == j1 || i2 == j2) {
                        continue;
                    } else if (data[i1] + data[i2] + data[j1] + data[j2] == 0) {
                        int[] set = new int[]{data[i1], data[i2], data[j1], data[j2]};
                        Arrays.sort(set);
                        int code = Arrays.hashCode(set);
                        if (!hash.contains(code)) {
                            count++;
                            hash.add(code);
                        }
                    }
                }
            }
        }
        return count;
    }

    private static Map<Integer, List<Integer>> getHashMap(int[] data) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int sum = data[i] + data[j];
                if (sum < 0) {
                    sum = -sum;
                }
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
        return map;
    }
}
