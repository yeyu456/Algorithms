package com.algorithms.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by yuye on 2016/9/16.
 */
public class DifferenceTest {

    public static double[] NUM;

    @BeforeClass
    public static void init() {
        int SIZE = 100000;
        double MAX = 1000000.0;
        DifferenceTest.NUM = new double[SIZE];
        for(int i=0;i<SIZE;i++) {
            double n = StdRandom.uniform(-MAX, MAX);
            DifferenceTest.NUM[i] = n;
            //System.out.print("," + DifferenceTest.NUM[i] + " ");
        }
        //System.out.println(" ");
    }

    //@Test
    public void getMinDiffNumR1() throws Exception {
        double[] min = Difference.getMinDiffNumR1(Arrays.copyOf(DifferenceTest.NUM, DifferenceTest.NUM.length));
        System.out.println("min r1 " + min[0] + " " + min[1] + " " + Math.abs(min[0] - min[1]));
    }

    //@Test
    public void getMinDiffNumR2() throws Exception {
        double[] min = Difference.getMinDiffNumR2(Arrays.copyOf(DifferenceTest.NUM, DifferenceTest.NUM.length));
        System.out.println("min r2 " + min[0] + " " + min[1] + " " + Math.abs(min[0] - min[1]));
    }

    @Test
    public void getMaxDiffNumR1() throws Exception {
        double[] min = Difference.getMaxDiffNumR1(Arrays.copyOf(DifferenceTest.NUM, DifferenceTest.NUM.length));
        System.out.println("max r1 " + min[0] + " " + min[1] + " " + Math.abs(min[0] - min[1]));
    }

    @Test
    public void getMaxDiffNumR2() throws Exception {
        double[] min = Difference.getMaxDiffNumR2(Arrays.copyOf(DifferenceTest.NUM, DifferenceTest.NUM.length));
        System.out.println("max r2 " + min[0] + " " + min[1] + " " + Math.abs(min[0] - min[1]));
    }

}