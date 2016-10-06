package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 4-sum test with brute-force search and double pointers implement
 * 4-sum的双指针结合暴力搜索测试
 */
public class FourSumBruteForceWithDoublePointerSearchTest {

    @Test(timeout = 200)
    public void bruteForceWithDoublePointerSearch() throws Exception {
        int count = FourSum.bruteForceWithDoublePointerSearch(Arrays.copyOf(NSumTestSuite.NUM_4, NSumTestSuite.NUM_4.length));
        System.out.println("4-sum with brute-force and double pointers search result:" + count);
    }

}