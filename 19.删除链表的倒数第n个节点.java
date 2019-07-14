import java.util.Stack;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> s = new Stack<>();

        ListNode first = head;
        int len = 0;
        while(first!=null){
            s.push(first);
            first = first.next;
            len++;
        }

        if(n == len){
            head = head.next;
        }else{
            int i = 0;
            ListNode temp = null;
            while(!s.empty()){
                temp = s.pop();
                if(++i == n){
                     break;
                }
            }
            ListNode target = s.pop();
            target.next = temp.next;
        }
        return head;
    }

    
}

