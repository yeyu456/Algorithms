package com.algorithms.search;

/**
 * exercise
 * 1.4.20
 */
public class BitonicSearch {

    public static int searchR1(int[] data, int num) {
        for (int i=0;i<data.length;i++) {
            if (data[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static int searchR2(int[] data, int num) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        } else if (data.length == 1) {
            return 0;
        }
        int maxIndex = BitonicSearch.getMax(data);
        if (maxIndex == -1) {
            throw new IllegalArgumentException("Not a bitonic data array.");

        } else if (num > data[maxIndex]) {
            return -1;

        } else if (num == data[maxIndex]) {
            return  maxIndex;

        } else {
            return BitonicSearch.getIndex(data, maxIndex, num);
        }
    }

    private static int getMax(int[] data) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] > data[mid - 1] &&
                    data[mid] > data[mid + 1]) {
                return mid;
            } else if (data[mid] < data[mid - 1]) {
                end = mid - 1;
            } else if (data[mid] < data[mid + 1]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int getIndex(int[] data, int maxIndex, int num) {
        int start = 0;
        int end = maxIndex - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == num) {
                return mid;

            } else if (data[mid] > num) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        start = maxIndex + 1;
        end = data.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (data[mid] == num) {
                return mid;

            } else if (data[mid] < num) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
