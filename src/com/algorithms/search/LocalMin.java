package com.algorithms.search;


/**
 * exercise
 * 1.4.18
 * 1.4.19
 */
public class LocalMin {

    /**
     * time complexity: O(N)
     */
    public static int getArrayLocalMinR1(int[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("invalid data.");
        }
        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] < data[i - 1] && data[i] < data[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * requirement:No duplicated num in 'data' array, otherwise the algorithm is not working.
     * time complexity: O(logN)
     */
    public static int getArrayLocalMinR2(int[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("invalid data.");
        }
        int start = 0;
        int end = data.length;
        int mid = (start + end) / 2;
        while (mid > 0 && mid < (data.length - 1)) {
            if (data[mid] < data[mid - 1] && data[mid] < data[mid + 1]) {
                return mid;
            }
            if (data[mid - 1] < data[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    /**
     * time complexity: O(N^2)
     */
    public static int[] getMatrixLocalMinR1(int[][] data) {
        if (data.length < 3 || data[0].length < 3) {
            throw new IllegalArgumentException("invalid data.");
        }
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data[i].length - 1; j++) {
                if (data[i][j] < data[i - 1][j] &&
                        data[i][j] < data[i + 1][j] &&
                        data[i][j] < data[i][j - 1] &&
                        data[i][j] < data[i][j + 1]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * requirement:No duplicated num in 'data' array, otherwise the algorithm is not working.
     * time complexity: O(N)
     */
    public static int[] getMatrixLocalMinR2(int[][] data) {
        if (data.length < 3 || data[0].length < 3) {
            throw new IllegalArgumentException("invalid data.");
        }
        int start = 0;
        int end = data.length - 1;
        int mid = (start + end) / 2;
        while (mid > start && mid < end) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i<data[mid].length;i++) {
                if (data[mid][i] < min) {
                    min = data[mid][i];
                    index = i;
                }
            }
            if (index != -1) {
                if (data[mid][index] < data[mid-1][index] &&
                        data[mid][index] < data[mid+1][index]) {
                    return new int[]{mid, index};

                } else if (data[mid][index] > data[mid-1][index]) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return null;
    }
}
