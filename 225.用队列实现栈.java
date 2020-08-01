import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    private Queue<Integer> q = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q.size();
        int i = 0;
        int temp = 0;
        while(i++ < size){
           temp = q.poll();
           if(i < size){
            q.add(temp);
           }
        }
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        int size = q.size();
        int i = 0;
        int temp = 0;
        while(i++ < size){
           temp = q.poll();
           q.add(temp);
        }
        return temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

