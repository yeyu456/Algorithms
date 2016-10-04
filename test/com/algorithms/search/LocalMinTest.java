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

    public static int[][] MATRIX_NUM;

    @BeforeClass
    public static void init() {
        int SIZE = 1000;
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
        System.out.println(" ");

        LocalMinTest.MATRIX_NUM = new int[SIZE][SIZE];
        set = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int n;
                do {
                    n = StdRandom.uniform(-MAX, MAX);
                } while (set.contains(n));
                set.add(n);
                LocalMinTest.MATRIX_NUM[i][j] = n;
            }
        }
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

    @Test
    public void getMatrixLocalMinR1() throws Exception {
        int[] index = LocalMin.getMatrixLocalMinR1(LocalMinTest.MATRIX_NUM);
        if (index != null) {
            System.out.println("matrix r1 (" + index[0] + ',' + index[1] + ") value:" + LocalMinTest.MATRIX_NUM[index[0]][index[1]]);
        } else {
            System.out.println("matrix r1 failed");
        }
    }

    @Test
    public void getMatrixLocalMinR2() throws Exception {
        int[] index = LocalMin.getMatrixLocalMinR2(LocalMinTest.MATRIX_NUM);
        if (index != null) {
            System.out.println("matrix r2 (" + index[0] + ',' + index[1] + ") value:" + LocalMinTest.MATRIX_NUM[index[0]][index[1]]);
            System.out.println("upper (" + (index[0]-1) + ',' + index[1] + ") value:" + LocalMinTest.MATRIX_NUM[index[0]-1][index[1]]);
            System.out.println("downer (" + (index[0]+1) + ',' + index[1] + ") value:" + LocalMinTest.MATRIX_NUM[index[0]+1][index[1]]);
            System.out.println("left (" + (index[0]) + ',' + (index[1] - 1) + ") value:" + LocalMinTest.MATRIX_NUM[index[0]][index[1]-1]);
            System.out.println("right (" + (index[0]) + ',' + (index[1] + 1) + ") value:" + LocalMinTest.MATRIX_NUM[index[0]][index[1]+1]);
        } else {
            System.out.println("matrix r2 failed");
        }
        /*for (int k = 0; k < LocalMinTest.MATRIX_NUM.length; k++) {
            for (int j = 0; j < LocalMinTest.MATRIX_NUM[k].length; j++) {
                System.out.print(LocalMinTest.MATRIX_NUM[k][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");*/
    }

}