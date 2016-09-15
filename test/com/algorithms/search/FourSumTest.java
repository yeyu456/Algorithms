package com.algorithms.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by yuye on 2016/9/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FourSumTest {

    public static int[] NUM;

    @BeforeClass
    public static void init(){
        int SIZE = 2000;
        int MAX = 10000000;
        FourSumTest.NUM = new int[SIZE];
        for(int i=0;i<SIZE;i++) {
            int n = StdRandom.uniform(-MAX, MAX);
            FourSumTest.NUM[i] = n;
            //System.out.print("," + FourSumTest.NUM[i] + " ");
        }
        //System.out.println(" ");
    }

    //@Test
    public void get4SumR1() throws Exception {
        int len = FourSum.fourSumR1(Arrays.copyOf(FourSumTest.NUM, FourSumTest.NUM.length));
        System.out.println("R1 " + len);
    }

    @Test
    public void get4SumR2() throws Exception {
        int len = FourSum.fourSumR2(Arrays.copyOf(FourSumTest.NUM, FourSumTest.NUM.length));
        System.out.println("R2 " + len);
    }

    @Test
    public void get4SumR3() throws Exception {
        int len = FourSum.fourSumR3(Arrays.copyOf(FourSumTest.NUM, FourSumTest.NUM.length));
        System.out.println("R3 " + len);
    }

    @Test
    public void get4SumR4() throws Exception {
        int len = FourSum.fourSumR4(Arrays.copyOf(FourSumTest.NUM, FourSumTest.NUM.length));
        System.out.println("R4 " + len);
    }

}