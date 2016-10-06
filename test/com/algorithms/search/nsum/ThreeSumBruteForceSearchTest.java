package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 3-sum test with brute-force search implement
 * 3-sum的暴力搜索测试
 */
public class ThreeSumBruteForceSearchTest {

    @Test(timeout = 10000)
    public void bruteForceSearch() throws Exception {
        int count = ThreeSum.bruteForceSearch(Arrays.copyOf(NSumTestSuite.NUM_3, NSumTestSuite.NUM_3.length));
        System.out.println("3-sum with brute-force search result:" + count);
    }
}