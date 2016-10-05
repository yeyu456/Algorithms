package com.algorithms.search.binary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test with small data set
 * 微量数据测试
 */
public class BinarySearchSmallTest {

    private Integer[] data;
    private List<Integer> keyList = new ArrayList<>();

    @Before
    public void init() throws Exception {
        List<Integer> dataList = new ArrayList<>();

        BufferedReader keyReader = new BufferedReader(new FileReader("./res/tinyT.txt"));
        BufferedReader dataReader = new BufferedReader(new FileReader("./res/tinyW.txt"));

        //load search number
        //读取用于搜索的数字
        String line;
        while ((line = keyReader.readLine()) != null) {
            this.keyList.add(Integer.parseInt(line.trim()));
        }

        //load search data list
        //读取数据集
        while ((line = dataReader.readLine()) != null) {
            dataList.add(Integer.parseInt(line.trim()));
        }
        this.data = dataList.toArray(new Integer[0]);
    }

    @Test
    public void search() {
        Assert.assertEquals(0, BinarySearch.search(new Integer[]{1, 2, 3}, 1));
        Assert.assertEquals(2, BinarySearch.search(new Integer[]{1, 2, 3, 4, 5}, 3));
        Assert.assertEquals(3, BinarySearch.search(new Integer[]{1, 2, 3, 4, 5}, 4));
        Assert.assertEquals(4, BinarySearch.search(new Integer[]{1, 2, 3, 4, 5, 6}, 5));

        Arrays.sort(this.data);
        for (int i = 0; i < this.keyList.size(); i++) {
            Integer key = this.keyList.get(i);
            if (key == 50 || key == 99 || key == 13) {
                Assert.assertEquals(-1, BinarySearch.search(this.data, key));

            } else {
                Assert.assertNotEquals(-1, BinarySearch.search(this.data, key));
            }
        }
    }
}