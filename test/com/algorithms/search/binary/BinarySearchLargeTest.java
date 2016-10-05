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
 * Test with large data set
 * 大量数据测试
 */
public class BinarySearchLargeTest {

    private Integer[] largeData;
    private List<Integer> largeKeyList = new ArrayList<>();

    @Before
    public void init() throws Exception {
        List<Integer> largeDataList = new ArrayList<>();
        BufferedReader largeKeyReader = new BufferedReader(new FileReader("./res/largeT.txt"));
        BufferedReader largeDataReader = new BufferedReader(new FileReader("./res/largeW.txt"));

        //load search number
        //读取用于搜索的数字
        String line;
        while ((line = largeKeyReader.readLine()) != null) {
            this.largeKeyList.add(Integer.parseInt(line.trim()));
        }

        //load search data list
        //读取数据集
        while ((line = largeDataReader.readLine()) != null) {
            largeDataList.add(Integer.parseInt(line.trim()));
        }
        this.largeData = largeDataList.toArray(new Integer[0]);
    }

    @Test
    public void search() {
        Arrays.sort(this.largeData);
        int missing = 0;
        for (int i = 0; i < this.largeKeyList.size(); i++) {
            Integer key = this.largeKeyList.get(i);
            int index = BinarySearch.search(this.largeData, key);
            if (index == -1) {
                missing++;
            }
        }
        Assert.assertEquals(367966, missing);
    }
}
