/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode swapPairs(ListNode head) {
    //     ListNode temp = new ListNode(0);
    //     temp.next = head;
    //     ListNode saved = temp;

    //     ListNode one = null;
    //     ListNode two = null;

    //    while(temp!=null && temp.next!=null && temp.next.next!=null){
    //        one = temp.next;
    //        two = temp.next.next;
    //        one.next = two.next;
    //        two.next = one;
    //        temp.next = two;
    //        temp = one;
    //    }
    //     return saved.next;   
    // }

    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}

