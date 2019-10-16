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

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
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