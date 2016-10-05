package com.algorithms.search.local;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.HashSet;
import java.util.Set;


/**
 * Local Element Search Test Suite
 * 局部元素搜索测试套件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayLocalMinBruteSearchTest.class, ArrayLocalMinBinarySearchTest.class,
        MatrixLocalMinBruteForceSearchTest.class, MatrixLocalMinBinarySearchTest.class})
public class LocalSearchTestSuite {

    public static int[] NUM;

    public static int[][] MATRIX_NUM;

    @BeforeClass
    public static void init() {
        int SIZE = 1000;
        int MAX = 10000000;
        LocalSearchTestSuite.NUM = new int[SIZE];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            int n;
            do {
                n = StdRandom.uniform(-MAX, MAX);
            } while (set.contains(n));
            set.add(n);
            LocalSearchTestSuite.NUM[i] = n;
        }

        LocalSearchTestSuite.MATRIX_NUM = new int[SIZE][SIZE];
        set = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int n;
                do {
                    n = StdRandom.uniform(-MAX, MAX);
                } while (set.contains(n));
                set.add(n);
                LocalSearchTestSuite.MATRIX_NUM[i][j] = n;
            }
        }

        //LocalSearchTestSuite.debug();
    }

    private static void debug() {

    }
}