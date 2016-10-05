package com.algorithms.search.distance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Farthest pair test with linear search implement
 * 最遥远的一对线性搜索测试
 */
public class FarthestLinearSearchTest {

    @Test
    public void linearSearch() throws Exception {
        int len = DistanceSearchTestSuite.NUM.length;
        double[] max = FarthestSearch.linearSearch(Arrays.copyOf(DistanceSearchTestSuite.NUM, len));

        Assert.assertNotNull(max);
        Assert.assertEquals(max.length, 2);

        System.out.println("farthest brute-force value:" + max[0] + "," + max[1] + " dist:" + Math.abs(max[0] - max[1]));
    }

}