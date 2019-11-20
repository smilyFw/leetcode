/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution {

    // public class ListNode {
    //     int val;
    //     ListNode next;

    //     ListNode(int x) {
    //         val = x;
    //     }
    // }

    private ListNode temp = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        
        int index = 1;
        ListNode from = dummy;
        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            if (index % k == 0) {
                temp = from.next;
                reverseK(from, cur);
                from = temp;
            }
            index++;
        }

        return dummy.next;
    }

    // 不移动head和end
    public void reverseK(ListNode head, ListNode end) {
        ListNode cur = head.next;
        ListNode n = null;
        while (cur != null && cur.next != end) {
            n = cur.next;
            cur.next = n.next;
            n.next = head.next;
            head.next = n;
        }
    }
}
