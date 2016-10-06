package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 4-sum test with brute-force search implement
 * 4-sum的暴力搜索测试
 */
public class FourSumBruteForceSearchTest {

    @Test(timeout = 13000)
    public void bruteForceSearch() throws Exception {
        int count = FourSum.bruteForceSearch(Arrays.copyOf(NSumTestSuite.NUM_4, NSumTestSuite.NUM_4.length));
        System.out.println("4-sum with brute-force search result:" + count);
    }

}