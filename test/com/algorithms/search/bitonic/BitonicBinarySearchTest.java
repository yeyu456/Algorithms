package com.algorithms.search.bitonic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test with binary search Implement
 * 二分搜索测试
 */
public class BitonicBinarySearchTest {

    @Test
    public void binarySearch() throws Exception {
        int len = BitonicSearchTestSuite.NUM.length;
        int searchIndex = BitonicSearch.binarySearch(Arrays.copyOf(BitonicSearchTestSuite.NUM, len),
                BitonicSearchTestSuite.SEARCH_NUM);
        Assert.assertNotEquals(searchIndex, -1);
    }
}