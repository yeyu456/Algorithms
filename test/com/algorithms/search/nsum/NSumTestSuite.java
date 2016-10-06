package com.algorithms.search.nsum;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.Arrays;

/**
 * 2-sum Test Suite
 * 2sum测试套件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TwoSumBruteForceSearchTest.class, TwoSumHashSearchTest.class,
    ThreeSumBruteForceSearchTest.class, ThreeSumHashSearchTest.class,
    FourSumBruteForceSearchTest.class, FourSumBruteForceWithDoublePointerSearchTest.class, FourSumHashSearchTest.class})
public class NSumTestSuite {

    public static int[] NUM_2;
    public static int[] NUM_3;
    public static int[] NUM_4;

    @BeforeClass
    public static void init() throws Exception {
        int SIZE = 100000;
        int MAX = Integer.MAX_VALUE / 20;
        NSumTestSuite.NUM_2 = new int[SIZE];
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            NSumTestSuite.NUM_2[i] = n;
        }
        Arrays.sort(NSumTestSuite.NUM_2);

        SIZE = 3000;
        MAX = Integer.MAX_VALUE / 200;
        NSumTestSuite.NUM_3 = new int[SIZE];
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            NSumTestSuite.NUM_3[i] = n;
        }
        Arrays.sort(NSumTestSuite.NUM_3);

        SIZE = 600;
        MAX = Integer.MAX_VALUE / 2000;
        NSumTestSuite.NUM_4 = new int[SIZE];
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            NSumTestSuite.NUM_4[i] = n;
        }
        Arrays.sort(NSumTestSuite.NUM_4);
    }
}