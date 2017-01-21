package com.algorithms.sort;

/**
 * LeetCode 148. Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        int[] data = new int[]{2,3,4,5};
        ListNode tmp = node;
        for (int d : data) {
            tmp.next = new ListNode(d);
            tmp = tmp.next;
        }
        sortList(node);
    }
}
