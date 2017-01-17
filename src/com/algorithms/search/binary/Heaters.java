package com.algorithms.search.binary;

import java.util.Arrays;

/**
 * LeetCode 475. Heaters
 * 
 * Winter is coming! Your first job during the contest is to 
 * design a standard heater with fixed warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, 
 * find out minimum radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, 
 * and your expected output will be the minimum radius standard of heaters.
 *
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * 
 *  Example 1:
 *     Input: [1,2,3],[2]
 *     Output: 1
 *  Explanation: The only heater was placed in the position 2, 
 *  and if we use the radius 1 standard, then all the houses can be warmed.
 *  
 *  Example 2:
 *     Input: [1,2,3,4],[1,4]
 *     Output: 1
 *  Explanation: The two heater was placed in the position 1 and 4. 
 *  We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters {

    public static int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) {
            return 0;
            
        } else if (heaters == null || heaters.length == 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int minLen = 0;
        int j;
        for (int i = 0; i <= heaters.length; i++) {
            int lastHeater = i==0 ? Integer.MIN_VALUE : heaters[i-1];
            int curHeater = i== heaters.length ? Integer.MAX_VALUE : heaters[i];
            for (j=0;j < houses.length && houses[j] <= curHeater;j++) {
                if (houses[j] >= lastHeater) {
                    int len;
                    if (i == 0) {
                        len = curHeater - houses[j];
                    } else if (i == heaters.length) {
                        len = houses[j] - lastHeater;
                    } else {
                        int len1 = houses[j] - lastHeater;
                        int len2 = curHeater - houses[j];
                        len = len1 > len2 ? len2 : len1;
                    }
                    if (minLen < len) {
                        minLen = len;
                    }
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, 
             new int[]{823564440,115438165, 784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
    }
}
