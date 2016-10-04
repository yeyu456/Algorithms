package com.algorithms.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yu on 2016/10/5.
 */
public class BitonicSearchTest {

    public static int[] NUM;

    @BeforeClass
    public static void init() {
        int SIZE = 1000;
        int MAX = 1000000;
        BitonicSearchTest.NUM = new int[SIZE];

        int MAX_INDEX = StdRandom.uniform(1, SIZE);
        for(int i=0;i<MAX_INDEX;i++) {

        }
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            BitonicSearchTest.NUM[i] = n;
            //System.out.print("," + FourSumTest.NUM[i] + " ");
        }
        //System.out.println(" ");
    }

    @Test
    public void searchR1() throws Exception {

    }

    @Test
    public void searchR2() throws Exception {

    }

}