package com.algorithms.search.local;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Find local min element in array test with brute-force search implement
 * 数组局部最小元素的暴力搜索测试
 */
public class ArrayLocalMinBruteSearchTest {

    @Test(timeout = 3000)
    public void bruteForceSearch() throws Exception {
        int len = LocalSearchTestSuite.NUM.length;
        int index = ArrayLocalMinSearch.bruteForceSearch(Arrays.copyOf(LocalSearchTestSuite.NUM, len));
        if (index != -1) {
            System.out.println("Array local min brute-force search index:" + index +
                    " value:" + LocalSearchTestSuite.NUM[index] +
                    " last:" + LocalSearchTestSuite.NUM[index - 1] +
                    " next:" + LocalSearchTestSuite.NUM[index + 1]);

        } else {
            System.out.println("Array local min brute-force search failed");
        }
    }
}