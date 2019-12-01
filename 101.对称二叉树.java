/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 !=null && root2 !=null){
            if(root1.val != root2.val){
                return false;
            }

           boolean left =  isSym(root1.left, root2.right);
           boolean right =  isSym(root1.right, root2.left);
           return left && right;

        }else{
            return false;
        }
    }
}
// @lc code=end

