package com.algorithms.search;

import com.algorithms.search.nsum.ThreeSum;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuye on 2016/9/16.
 */
public class ThreeSumTest {

    public static int[] NUM;

    @BeforeClass
    public static void init() throws Exception {
        int SIZE = 5000;
        int MAX = 5000000;
        ThreeSumTest.NUM = new int[SIZE];
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            ThreeSumTest.NUM[i] = n;
            //System.out.print("," + ThreeSumTest.NUM[i] + " ");
        }
        //System.out.println(" ");
    }

    @Test
    public void threeSumR1() throws Exception {
        int len = ThreeSum.threeSumR1(Arrays.copyOf(ThreeSumTest.NUM, ThreeSumTest.NUM.length));
        System.out.println("r1 " + len);
    }

    @Test
    public void threeSumR2() throws Exception {
        int len = ThreeSum.threeSumR2(Arrays.copyOf(ThreeSumTest.NUM, ThreeSumTest.NUM.length));
        System.out.println("r2 " + len);
    }

}