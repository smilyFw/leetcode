import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        String str = "";
        helper(root, str);
        return result;
    }

    private void helper(TreeNode root, String str){
         if(root == null){
             return ;
         }
         
         if(str.isEmpty()){
             str = String.valueOf(root.val);
         }else{
             str = str.concat("->"+root.val);
         }
         if(root.left == null && root.right == null){
             result.add(str);
             return;
         }

         helper(root.left, str);
         helper(root.right, str);
    }
}
// @lc code=end

