package com.algorithms.search.distance;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Distance Search Test Suite
 * 距离搜索测试套件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ClosestBruteForceSearchTest.class, ClosestQuickSortSearchTest.class,
        FarthestBruteForceSearchTest.class, FarthestLinearSearchTest.class})
public class DistanceSearchTestSuite {

    public static double[] NUM;

    @BeforeClass
    public static void init() {
        int SIZE = 100000;
        double MAX = 1000000.0d;
        DistanceSearchTestSuite.NUM = new double[SIZE];
        for(int i=0;i<SIZE;i++) {
            double n = StdRandom.uniform(-MAX, MAX);
            DistanceSearchTestSuite.NUM[i] = n;
        }

        //DistanceSearchTestSuite.debug();
    }

    private static void debug() {

    }
}