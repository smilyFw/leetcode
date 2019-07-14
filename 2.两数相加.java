/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list. 
 * public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur =  head;
        int over = 0;
        int v1 = 0;
        int v2 = 0;
        int add = 0;
        int value = 0;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1 != null || temp2 != null || over != 0){

            v1=0;
            v2=0;
            
            if(temp1!= null){
                v1 = temp1.val;
                temp1 = temp1.next;
            }
            
            if(temp2!=null){
                v2 = temp2.val;
                temp2 = temp2.next;
            }

            add = v1 + v2 + over;
            over = add / 10;
            value = add % 10;

           
            cur.next = new ListNode(value);
            cur = cur.next;
          
        }
        return head.next;
    }
}
