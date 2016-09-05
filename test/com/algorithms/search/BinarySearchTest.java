package com.algorithms.search;

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

    private Integer[] data;
    private List<Integer> keyList;

    private Integer[] largeData;
    private List<Integer> largeKeyList;

    @Before
    public void init() throws Exception {
        this.keyList = new ArrayList<>();
        this.largeKeyList = new ArrayList<>();

        List<Integer> dataList = new ArrayList<>();
        List<Integer> largeDataList = new ArrayList<>();

        BufferedReader keyReader = new BufferedReader(new FileReader("./test/com/algorithms/search/tinyT.txt"));
        BufferedReader dataReader = new BufferedReader(new FileReader("./test/com/algorithms/search/tinyW.txt"));
        BufferedReader largeKeyReader = new BufferedReader(new FileReader("./test/com/algorithms/search/largeT.txt"));
        BufferedReader largeDataReader = new BufferedReader(new FileReader("./test/com/algorithms/search/largeW.txt"));

        String line = null;
        while ((line = keyReader.readLine()) != null) {
            this.keyList.add(Integer.parseInt(line.trim()));
        }

        line = null;
        while ((line = dataReader.readLine()) != null) {
            dataList.add(Integer.parseInt(line.trim()));
        }
        this.data = dataList.toArray(new Integer[0]);

        line = null;
        while ((line = largeKeyReader.readLine()) != null) {
            this.largeKeyList.add(Integer.parseInt(line.trim()));
        }

        line = null;
        while ((line = largeDataReader.readLine()) != null) {
            largeDataList.add(Integer.parseInt(line.trim()));
        }
        this.largeData = largeDataList.toArray(new Integer[0]);
    }


    @Test
    public void search() throws Exception {
        assertEquals(0, BinarySearch.search(1, new Integer[]{1, 2, 3}));
        assertEquals(2, BinarySearch.search(3, new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(3, BinarySearch.search(4, new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(4, BinarySearch.search(5, new Integer[]{1, 2, 3, 4, 5, 6}));

        Arrays.sort(this.data);
        for (int i = 0; i < this.keyList.size(); i++) {
            Integer key = this.keyList.get(i);
            if (key == 50 || key == 99 || key == 13) {
                assertEquals(-1, BinarySearch.search(key, this.data));

            } else {
                assertNotEquals(-1, BinarySearch.search(key, this.data));
            }
        }
    }

    @Test(timeout=3000)
    public void largeSeach() throws Exception {
        Arrays.sort(this.largeData);
        int missing = 0;
        for (int i = 0; i < this.largeKeyList.size(); i++) {
            Integer key = this.largeKeyList.get(i);
            int index = BinarySearch.search(key, this.largeData);
            if (index == -1) {
                missing++;
            }
        }
        System.out.println(this.largeData.length + ":" + this.largeKeyList.size() + ":" + missing);
    }

}