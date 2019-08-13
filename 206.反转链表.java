/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList1(ListNode head) {
        ListNode next = null;
        ListNode newHead = null;
        while(head!=null){
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public ListNode reverseList(ListNode head) {
        return reverseTwo(head, null);
    }

    public ListNode reverseTwo(ListNode head, ListNode newHead){
         if(head == null){
             return newHead;
         }

         ListNode next = head.next;
         head.next = newHead;
         return reverseTwo(next, head);
    }

}

