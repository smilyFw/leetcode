/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        int dep = 0;
        return maxDep(root, dep);
    }

    private int maxDep(TreeNode root, int dep){
         if(root == null){
             return dep;
         }
         dep ++;
         if(root.left == null && root.right == null){
             return dep;
         }

         int left = maxDep(root.left, dep);
         int right = maxDep(root.right, dep);
         return Math.max(left , right);
    }
}
// @lc code=end

