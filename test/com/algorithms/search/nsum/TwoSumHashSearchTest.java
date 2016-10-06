package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2-sum test with hash search implement
 * 2-sum的哈希搜索测试
 */
public class TwoSumHashSearchTest {

    @Test(timeout = 100)
    public void hashSearch() throws Exception {
        int count = TwoSum.hashSearch(Arrays.copyOf(NSumTestSuite.NUM_2, NSumTestSuite.NUM_2.length));
        System.out.println("2-sum with hash search result:" + count);
    }
}