package com.algorithms.search.binary;

/**
 * Binary Search Generic Implement In Sorted Array
 * 排序好的数组中，二分搜索算法泛型实现
 */
public class BinarySearch {

    /**
     * 二分搜索查找
     * @param data 数据集
     * @param num 查找数值
     * @param <T> 查找数据类型，必须实现比较接口
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static <T extends Comparable> int search(T[] data, T num) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid data array.");

        } else if (num == null) {
            throw new IllegalArgumentException("Null search number.");
        }

        int lo = 0;
        int hi = data.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int v = num.compareTo(data[mid]);

            if (v > 0) {
                lo = mid + 1;

            } else if (v < 0) {
                hi = mid - 1;

            } else {
                return mid;
            }
        }
        return -1;
    }
}
