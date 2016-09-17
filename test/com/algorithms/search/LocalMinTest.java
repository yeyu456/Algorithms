package com.algorithms.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by yuye on 2016/9/17.
 */
public class LocalMinTest {

    public static int[] NUM;

    @BeforeClass
    public static void init() {
        int SIZE = 200000;
        int MAX = 100000000;
        LocalMinTest.NUM = new int[SIZE];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            int n;
            do {
                n = StdRandom.uniform(-MAX, MAX);
            } while (set.contains(n));
            set.add(n);
            LocalMinTest.NUM[i] = n;
            //System.out.print("," + LocalMinTest.NUM[i] + " ");
        }
        //System.out.println(" ");
    }

    @Test
    public void getArrayLocalMinR1() throws Exception {
        int index = LocalMin.getArrayLocalMinR1(Arrays.copyOf(LocalMinTest.NUM, LocalMinTest.NUM.length));
        if (index != -1) {
            System.out.println("r1 " + index + " value:" + LocalMinTest.NUM[index] +
                    " last:" + LocalMinTest.NUM[index - 1] + " next:" + LocalMinTest.NUM[index + 1]);
        } else {
            System.out.println("r1 failed");
        }
    }

    @Test
    public void getArrayLocalMinR2() throws Exception {
        int index = LocalMin.getArrayLocalMinR2(Arrays.copyOf(LocalMinTest.NUM, LocalMinTest.NUM.length));
        if (index != -1) {
            System.out.println("r2 " + index + " value:" + LocalMinTest.NUM[index] +
                    " last:" + LocalMinTest.NUM[index - 1] + " next:" + LocalMinTest.NUM[index + 1]);
        } else {
            System.out.println("r2 failed");
        }
    }

}