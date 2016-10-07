package com.algorithms.search.binary;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yu on 2016/10/8.
 */
public class FibonacciSearchTest {

    @Test
    public void search() throws Exception {
        int[] data = new int[]{1, 3, 5, 7, 9, 11, 13, 15};
        for(int i=0;i<data.length;i++) {
            Assert.assertEquals(i, FibonacciSearch.search(data, data[i]));
            Assert.assertEquals(-1, FibonacciSearch.search(data, data[i] + 1));
        }
    }

}