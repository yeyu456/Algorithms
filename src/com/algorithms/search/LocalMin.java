package com.algorithms.search;


/**
 * Created by yuye on 2016/9/16.
 */
public class LocalMin {

    public static int getOneLocalMinR1(int[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("invalid data.");
        }
        for(int i=1;i<data.length-1;i++) {
            if (data[i] < data[i-1] && data[i] < data[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
