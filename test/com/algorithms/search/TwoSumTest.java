package com.algorithms.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by yu on 2016/9/15.
 */
public class TwoSumTest {

    public static int[] NUM;

    @BeforeClass
    public static void init() throws Exception {
        int SIZE = 10000;
        int MAX = 100000;
        TwoSumTest.NUM = new int[SIZE];
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            TwoSumTest.NUM[i] = n;
        }
    }

    @Test
    public void twoSumR1() throws Exception {
        int len = TwoSum.twoSumR1(Arrays.copyOf(TwoSumTest.NUM, TwoSumTest.NUM.length));
        System.out.println("r1 " + len);
    }

    @Test
    public void twoSumR2() throws Exception {
        int len = TwoSum.twoSumR2(Arrays.copyOf(TwoSumTest.NUM, TwoSumTest.NUM.length));
        System.out.println("r2 " + len);
    }

}