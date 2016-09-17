package com.algorithms.search;

import java.util.*;

/**
 * exercise
 * 1.4.14
 */
public class FourSum {

    public static int fourSumR1(int[] data) {
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

        Set<Integer> hash = new HashSet<>();
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
                                int[] set = new int[]{data[m1], data[m2], data[c1], data[c2]};
                                Arrays.sort(set);
                                int code = Arrays.hashCode(set);
                                if (!hash.contains(code)) {
                                    //System.out.println("r2 " + data[m1]  + " " +  data[m2]  + " " +  data[c1]  + " " +  data[c2]);
                                    count++;
                                    hash.add(code);
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        return count;
    }

    public static int fourSumR3(int[] data) {
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
                        //System.out.println("r3 " + data[i]  + " " +  data[j]  + " " +  data[left]  + " " +  data[right]);
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

    public static int fourSumR4(int[] data) {
        int count = 0;
        Arrays.sort(data);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int sum = data[i] + data[j];
                if (sum < 0) {
                    sum = - sum;
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

        Set<Integer> hash = new HashSet<>();
        for (Integer key:map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() >= 4) {
                for(int i=0;i<list.size();i+=2) {
                    for(int j=i+2;j<list.size();j+=2) {
                        int i1 = list.get(i);
                        int i2 = list.get(i+1);
                        int j1 = list.get(j);
                        int j2 = list.get(j+1);
                        if (i1 == j1 || i1 == j2 || i2 == j1 || i2 == j2) {
                            continue;
                        } else if (data[i1] + data[i2] + data[j1] + data[j2] == 0) {
                            int[] set = new int[]{data[i1], data[i2], data[j1], data[j2]};
                            Arrays.sort(set);
                            int code = Arrays.hashCode(set);
                            if (!hash.contains(code)) {
                                //System.out.println("r4 " + data[i1]  + " " +  data[i2]  + " " +  data[j1]  + " " +  data[j2]);
                                count++;
                                hash.add(code);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
