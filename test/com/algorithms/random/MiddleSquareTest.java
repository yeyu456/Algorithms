package com.algorithms.random;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test with middle square method
 * 平方取中方法测试
 */
public class MiddleSquareTest {

    @Test
    public void random() throws Exception {
        int size = 150;
        MiddleSquare ms = new MiddleSquare();
        Set<Integer> set = new HashSet<>();
        ms.setSeed(940181);
        for (int i = 0; i < size; i++) {
            set.add(ms.random());
        }
        Assert.assertTrue(set.size() < size);
    }

}