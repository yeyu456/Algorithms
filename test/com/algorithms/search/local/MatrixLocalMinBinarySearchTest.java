package com.algorithms.search.local;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Find local min element in matrix test with brute-force search implement
 * 矩阵局部最小元素的二分搜索测试
 */
public class MatrixLocalMinBinarySearchTest {

    @Test
    public void binarySearch() throws Exception {
        int[] index = MatrixLocalMinSearch.binarySearch(LocalSearchTestSuite.MATRIX_NUM);
        if (index != null) {
            System.out.println("Matrix local min binary search result:");
            System.out.println("                     (" + (index[0]-1) + ',' + index[1] + ") value:" + LocalSearchTestSuite.MATRIX_NUM[index[0]-1][index[1]]);
            System.out.print("(" + (index[0]) + ',' + (index[1] - 1) + ") value:" + LocalSearchTestSuite.MATRIX_NUM[index[0]][index[1]-1]);
            System.out.print("  (" + index[0] + ',' + index[1] + ") value:" + LocalSearchTestSuite.MATRIX_NUM[index[0]][index[1]]);
            System.out.println("  (" + (index[0]) + ',' + (index[1] + 1) + ") value:" + LocalSearchTestSuite.MATRIX_NUM[index[0]][index[1]+1]);
            System.out.println("                     (" + (index[0]+1) + ',' + index[1] + ") value:" + LocalSearchTestSuite.MATRIX_NUM[index[0]+1][index[1]]);

        } else {
            System.out.println("Matrix local min binary search failed");
        }
    }

}