import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    int result = -1;
    public int findSecondMinimumValue(TreeNode root) {
        Integer[] min = {Integer.MAX_VALUE, null};
        helper(root, min);
        return (min[1] == null) ? -1 : min[1];
    }

    private void helper(TreeNode root, Integer[] min){
        if(root == null){
            return;
        }
        
        if(root.val < min[0]){
            min[0] = root.val;
        }else if(root.val > min[0]){
            if(min[1] == null || root.val < min[1]){
                min[1] = root.val;
            }
        }
        helper(root.left, min);
        helper(root.right, min);
    }
}
// @lc code=end

