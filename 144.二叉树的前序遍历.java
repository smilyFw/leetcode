import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeNode cur = root;

        Stack<TreeNode> stack = new Stack<>();

        while(cur!= null || !stack.empty()){
            while(cur!=null){
                result.add(cur.val);
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }
}

