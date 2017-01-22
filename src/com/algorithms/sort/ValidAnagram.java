package com.algorithms.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 242. Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 *      You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 *      What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return new String(sa).equals(new String(ta));
    }
}
