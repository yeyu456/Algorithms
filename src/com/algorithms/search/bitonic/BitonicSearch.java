package com.algorithms.search.bitonic;

/**
 * Algorithms 4th exercise 1.4.20 Bitonic Array Search Implement
 * 算法第4版 习题 1.4.20 双调数组查找实现
 */
public class BitonicSearch {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @param key 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static int bruteForceSearch(int[] data, int key) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        }

        for (int i=0;i<data.length;i++) {
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分搜索实现
     * @param data 数据集
     * @param key 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static int binarySearch(int[] data, int key) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        }

        int maxIndex = BitonicSearch.getMaxIndex(data);
        if (maxIndex == -1) {
            throw new IllegalArgumentException("Invalid bitonic data array.");

        } else if (key > data[maxIndex]) {
            return -1;

        } else if (key == data[maxIndex]) {
            return  maxIndex;

        } else {
            int index = searchIncrementPart(data, maxIndex, key);
            if (index == -1) {
                index = searchDecrementPart(data, maxIndex, key);
            }
            return index;
        }
    }

    /**
     * 找出双调数组中的最大数值的下标序号
     * @param data 数据集
     * @return (-1:找不到最大值;其他:最大数值的下标序号)
     */
    private static int getMaxIndex(int[] data) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] > data[mid - 1] &&
                    data[mid] > data[mid + 1]) {
                return mid;
            } else if (data[mid] < data[mid - 1]) {
                end = mid - 1;
            } else if (data[mid] < data[mid + 1]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在双调数组递增部分查找
     * @param data 数据集
     * @param maxIndex 双调数组中的最大数值的下标序号
     * @param key 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    private static int searchIncrementPart(int[] data, int maxIndex, int key) {
        int start = 0;
        int end = maxIndex - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == key) {
                return mid;

            } else if (data[mid] > key) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在双调数组递减部分查找
     * @param data 数据集
     * @param maxIndex 双调数组中的最大数值的下标序号
     * @param key 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    private static int searchDecrementPart(int[] data, int maxIndex, int key) {
        int start = maxIndex + 1;
        int end = data.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == key) {
                return mid;

            } else if (data[mid] < key) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
