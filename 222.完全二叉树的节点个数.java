/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1 << left);
        }else{
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root){
         int level = 0;
         TreeNode temp = root;
         while(temp!=null){
             level++;
             temp = temp.left;
         }
         return level;
    }
}
// @lc code=end

