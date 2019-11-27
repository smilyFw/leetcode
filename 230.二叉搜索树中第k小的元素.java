import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }

        TreeNode temp = null;
        TreeNode right = null;
        while(k>0){
            temp = stack.pop();
            k--;
            if(k == 0){
                return temp.val;
            }
            right = temp.right;
            while(right != null){
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
    
}
// @lc code=end
