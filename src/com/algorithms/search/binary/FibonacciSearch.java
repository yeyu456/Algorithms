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
        //In case of last element not checked
        //防止最后一个元素没被检查到
        if (data[data.length-1] == num) {
            return data.length-1;
        }
        int k1 = 1;
        int k2 = 1;
        while (k2 < data.length) {
            int tmp = k2;
            k2 = k1 + k2;
            k1 = tmp;
        }
        int i = -1;
        while(k2 > 1) {
            int k0 = k2 - k1;
            int index = i + k0;
            //In case of array out of bound
            //防止超出数组大小
            if (index > data.length - 1) {
                index = data.length - 1;
            }
            if (data[index] == num) {
                return index;

            }  else if (data[index] > num) {
                k2 = k0;
                k1 -= k0;

            } else {
                k2 = k1;
                k1 = k0;
                i += k0;
            }
        }
        return -1;
    }
}
