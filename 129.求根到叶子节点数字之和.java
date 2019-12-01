import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return total;
    }
    private void helper(TreeNode root, int sum){
        if(root == null) return;
        sum = sum*10+root.val;
        if(root.left == null && root.right == null){
            total += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
// @lc code=end

