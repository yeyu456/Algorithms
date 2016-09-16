package com.algorithms.search;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yu on 2016/9/4.
 */
public class BinarySearchTest {

    public static Integer[] data;
    public static List<Integer> keyList = new ArrayList<>();

    public static Integer[] largeData;
    public static List<Integer> largeKeyList = new ArrayList<>();

    public static int[] NUM;

    @BeforeClass
    public static void init() throws Exception {
        List<Integer> dataList = new ArrayList<>();
        List<Integer> largeDataList = new ArrayList<>();

        BufferedReader keyReader = new BufferedReader(new FileReader("./res/tinyT.txt"));
        BufferedReader dataReader = new BufferedReader(new FileReader("./res/tinyW.txt"));
        BufferedReader largeKeyReader = new BufferedReader(new FileReader("./res/largeT.txt"));
        BufferedReader largeDataReader = new BufferedReader(new FileReader("./res/largeW.txt"));

        String line = null;
        while ((line = keyReader.readLine()) != null) {
            BinarySearchTest.keyList.add(Integer.parseInt(line.trim()));
        }

        line = null;
        while ((line = dataReader.readLine()) != null) {
            dataList.add(Integer.parseInt(line.trim()));
        }
        BinarySearchTest.data = dataList.toArray(new Integer[0]);

        line = null;
        while ((line = largeKeyReader.readLine()) != null) {
            BinarySearchTest.largeKeyList.add(Integer.parseInt(line.trim()));
        }

        line = null;
        while ((line = largeDataReader.readLine()) != null) {
            largeDataList.add(Integer.parseInt(line.trim()));
        }
        BinarySearchTest.largeData = largeDataList.toArray(new Integer[0]);
    }

    @Test
    public void search() throws Exception {
        assertEquals(0, BinarySearch.search(1, new Integer[]{1, 2, 3}));
        assertEquals(2, BinarySearch.search(3, new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(3, BinarySearch.search(4, new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(4, BinarySearch.search(5, new Integer[]{1, 2, 3, 4, 5, 6}));

        Arrays.sort(BinarySearchTest.data);
        for (int i = 0; i < BinarySearchTest.keyList.size(); i++) {
            Integer key = BinarySearchTest.keyList.get(i);
            if (key == 50 || key == 99 || key == 13) {
                assertEquals(-1, BinarySearch.search(key, BinarySearchTest.data));

            } else {
                assertNotEquals(-1, BinarySearch.search(key, BinarySearchTest.data));
            }
        }
    }

    @Test(timeout=3000)
    public void largeSeach() throws Exception {
        Arrays.sort(BinarySearchTest.largeData);
        int missing = 0;
        for (int i = 0; i < BinarySearchTest.largeKeyList.size(); i++) {
            Integer key = BinarySearchTest.largeKeyList.get(i);
            int index = BinarySearch.search(key, BinarySearchTest.largeData);
            if (index == -1) {
                missing++;
            }
        }
        System.out.println(BinarySearchTest.largeData.length + ":" + BinarySearchTest.largeKeyList.size() + ":" + missing);
    }

}