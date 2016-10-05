package com.algorithms.search.distance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Closest pair test with brute-force search implement
 * 最接近一对的暴力搜索测试
 */
public class ClosestBruteForceSearchTest {

    @Test(timeout = 12000)
    public void bruteForceSearch() throws Exception {
        int len = DistanceSearchTestSuite.NUM.length;
        double[] min = ClosestSearch.bruteForceSearch(Arrays.copyOf(DistanceSearchTestSuite.NUM, len));

        Assert.assertNotNull(min);
        Assert.assertEquals(min.length, 2);

        System.out.println("closest brute-force value:" + min[0] + "," + min[1] + " dist:" + Math.abs(min[0] - min[1]));
    }
}