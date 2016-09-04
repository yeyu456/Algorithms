package com.algorithms.search;

import org.junit.Test;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yu on 2016/9/4.
 */
public class BinarySearchTest {

    private Integer[] data;
    private List<Integer> keyList;

    @Before
    public void init() throws Exception {
        this.keyList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        BufferedReader keyReader = new BufferedReader(new FileReader("./test/com/algorithms/search/tinyT.txt"));
        BufferedReader DataReader = new BufferedReader(new FileReader("./test/com/algorithms/search/tinyW.txt"));
        String line = null;
        while ((line = keyReader.readLine()) != null) {
            this.keyList.add(Integer.parseInt(line.trim()));
        }
        line = null;
        while ((line = DataReader.readLine()) != null) {
            dataList.add(Integer.parseInt(line.trim()));
        }
        this.data = dataList.toArray(new Integer[0]);
    }


    @Test
    public void search() throws Exception {
        assertEquals(0, BinarySearch.search(1, new Integer[]{3, 2, 1}));
        assertEquals(2, BinarySearch.search(3, new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(3, BinarySearch.search(4, new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(4, BinarySearch.search(5, new Integer[]{1, 2, 3, 4, 5, 6}));

        for (int i = 0; i < this.keyList.size(); i++) {
            Integer key = this.keyList.get(i);
            if (key == 50 || key == 99 || key == 13) {
                assertEquals(-1, BinarySearch.search(key, this.data));

            } else {
                assertNotEquals(-1, BinarySearch.search(key, this.data));
            }
        }
    }

}