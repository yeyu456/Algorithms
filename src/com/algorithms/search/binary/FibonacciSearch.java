package com.algorithms.search.binary;

/**
 * Algorithms 4th exercise 1.4.22 Fibonacci Search Implement In Ascending Order Array With Distinct Numbers
 * 算法第4版 习题 1.4.22 升序排列的无重复数字数组中，基于斐波那契的二分搜索实现
 */
public class FibonacciSearch {

    /**
     * 基于斐波那契的二分搜索实现
     * @param data 数据集
     * @param num 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static int search(int[] data, int num) {
        int k1 = 1;
        int k2 = 2;
        while(k2 < data.length) {
            int k0 = k2 - k1;
            if (data[k0] == num) {
                return k1;

            }  else if (data[k0] > num) {
                int tmp = k2;
                k2 = k1 + k2;
                k1 = tmp;

            } else {
                
            }
        }
        return -1;
    }
}
