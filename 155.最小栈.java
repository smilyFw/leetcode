/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private Node head;
    private Node tail;
    private int curMin = Integer.MIN_VALUE;

    class Node{
        private Node pre;
        private int val;
        private Node next;
        private int min;
        private Node(int val){
            this.val = val;
        }
    }
    /** initialize your data structure here. */
    public MinStack() {
        this.head = new Node(-1);
    }
    
    public void push(int x) {
        Node newNode = new Node(x);
        if(head.next == null){
            head.next = newNode;
            newNode.pre = head;
            tail = newNode;
            curMin = x;
            newNode.min = x;
        }else{
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
            if(curMin > x){
                curMin = x;
                newNode.min = x;
            }else{
                newNode.min = curMin;
            }
        }
    }
    
    public void pop() {
        tail.pre.next = null;
        tail = tail.pre;
        curMin = tail.min;  
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        if(tail == null){
            return curMin;
        }else{
            return tail.min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

