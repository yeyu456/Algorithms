package com.algorithms.search.nsum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 3-sum test with hash search implement
 * 3-sum的哈希搜索测试
 */
public class ThreeSumHashSearchTest {

    @Test(timeout = 100)
    public void hashSearch() throws Exception {
        int count = ThreeSum.hashSearch(Arrays.copyOf(NSumTestSuite.NUM_3, NSumTestSuite.NUM_3.length));
        System.out.println("3-sum with hash search result:" + count);
    }

}