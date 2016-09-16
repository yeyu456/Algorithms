package com.algorithms.search;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Created by yuye on 2016/9/16.
 */
public class Difference {

    public static double[] getMinDiffNumR1(double[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("invalid data.");
        }
        double r1 = Double.MIN_VALUE;
        double r2 = Double.MAX_VALUE;
        double diff = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                double tmpDidff = Math.abs(data[i] - data[j]);
                if (tmpDidff < diff) {
                    diff = tmpDidff;
                    r1 = data[i];
                    r2 = data[j];
                }
            }
        }
        return new double[]{r1, r2};
    }

    public static double[] getMinDiffNumR2(double[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("invalid data.");
        }
        Arrays.sort(data);
        double r1 = data[0];
        double r2 = data[1];
        double diff = Math.abs(r1 - r2);
        for (int i = 2; i < data.length; i++) {
            double tmpDidff = Math.abs(data[i] - data[i - 1]);
            if (tmpDidff < diff) {
                diff = tmpDidff;
                r1 = data[i - 1];
                r2 = data[i];
            }
        }
        return new double[]{r1, r2};
    }

    public static double[] getMinDiffNumR3(double[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("invalid data.");
        }
    }

    public static double[] getMaxDiffNumR1(double[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("invalid data.");
        }
        double r1 = 0.0;
        double r2 = 0.0;
        double diff = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                double tmpDidff = Math.abs(data[i] - data[j]);
                if (tmpDidff > diff) {
                    diff = tmpDidff;
                    r1 = data[i];
                    r2 = data[j];
                }
            }
        }
        return new double[]{r1, r2};
    }

    public static double[] getMaxDiffNumR2(double[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("invalid data.");
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 2; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (data[i] > max) {
                max = data[i];
            }
        }
        return new double[]{min, max};
    }
}
