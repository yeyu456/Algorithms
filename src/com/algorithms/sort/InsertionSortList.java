package com.algorithms.sort;

/**
 * LeetCode 147. Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {

    static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
            
            ListNode tmp = last;
            while (tmp.next != null && tmp.val > tmp.next.val) {
                int v = tmp.next.val;
                tmp.next.val = tmp.val;
                tmp.val = v;
                tmp = tmp.next;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        int[] data = new int[]{2,3,4,5};
        ListNode tmp = node;
        for (int d : data) {
            tmp.next = new ListNode(d);
            tmp = tmp.next;
        }
        insertionSortList(node);
    }
}
