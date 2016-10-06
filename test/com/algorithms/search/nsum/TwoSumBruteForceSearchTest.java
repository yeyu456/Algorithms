package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2-sum test with brute-force search implement
 * 2-sum的暴力搜索测试
 */
public class TwoSumBruteForceSearchTest {

    @Test(timeout = 10000)
    public void bruteForceSearch() throws Exception {
        int count = TwoSum.bruteForceSearch(Arrays.copyOf(NSumTestSuite.NUM_2, NSumTestSuite.NUM_2.length));
        System.out.println("2-sum with brute-force search result:" + count);
    }
}