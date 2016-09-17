package com.algorithms.search;

/**
 * content
 * 1.1
 */
public class BinarySearch {

    public static <T extends Comparable> int search(T key, T[] data) {
        int lowIndex = 0;
        int highIndex = data.length - 1;
        while(lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            int v = key.compareTo(data[midIndex]);

            if (v > 0) {
                lowIndex = midIndex + 1; // +1 and -1 exclude the compared middle num，decrease compare time
            } else if (v < 0) {
                highIndex = midIndex - 1;

            } else {
                return  midIndex;
            }
        }
        return -1;
    }
}
