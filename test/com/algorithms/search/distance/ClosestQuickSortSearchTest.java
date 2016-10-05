package com.algorithms.search.distance;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Closest pair test with quick-sort-linear search implement
 * 最接近一对的双基准快排-线性搜索测试
 */
public class ClosestQuickSortSearchTest {

    @Test(timeout = 1000)
    public void quickSortSearch() throws Exception {
        int len = DistanceSearchTestSuite.NUM.length;
        double[] min = ClosestSearch.quickSortSearch(Arrays.copyOf(DistanceSearchTestSuite.NUM, len));

        Assert.assertNotNull(min);
        Assert.assertEquals(min.length, 2);

        System.out.println("closest quick-sort value:" + min[0] + "," + min[1] + " dist:" + Math.abs(min[0] - min[1]));
    }
}