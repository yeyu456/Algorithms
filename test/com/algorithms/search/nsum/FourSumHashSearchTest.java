package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 4-sum test with hash search implement
 * 4-sum的哈希搜索测试
 */
public class FourSumHashSearchTest {

    @Test(timeout = 120)
    public void hashSearch() throws Exception {
        int count = FourSum.hashSearch(Arrays.copyOf(NSumTestSuite.NUM_4, NSumTestSuite.NUM_4.length));
        System.out.println("4-sum with hash search result:" + count);
    }

}