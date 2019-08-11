/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode result = lists[0];
        for(int i = 1; i< lists.length; i++){
            result = combine(result, lists[i]);
        }
        return result;
    }

    public ListNode combine(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = combine(l1.next, l2);
            return l1;
        }else{
            l2.next = combine(l1, l2.next);
            return l2;
        }
    }
}

