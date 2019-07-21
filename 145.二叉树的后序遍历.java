import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                result.addFirst(cur.val);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        return result;        
    }
}

