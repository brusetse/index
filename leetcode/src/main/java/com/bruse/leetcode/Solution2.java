package com.bruse.leetcode;

public class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l = addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode init = new ListNode(0);
        ListNode result = init;
        ListNode elm1 = l1;
        ListNode elm2 = l2;
        while (elm1 != null || elm2 != null) {
            int sum = 0;
            if (elm1 != null && elm2 != null) {
                sum = elm1.val + elm2.val;
            } else if (elm1 != null) {
                sum = elm1.val;
            } else {
                sum = elm2.val;
            }
            if (sum < 10) {
                result.val = sum;
            } else {
                result.val = sum - 10;
                if (elm1.next != null) {
                    elm1.next.val = elm1.next.val + 1;
                } else {
                    elm1.next = new ListNode(1);
                }
            }
            elm1 = elm1 != null ? elm1.next : null;
            elm2 = elm2 != null ? elm2.next : null;
            if (elm1 != null || elm2 != null) {
                result.next = new ListNode(0);
                result = result.next;
            }
        }

        return init;
    }
}