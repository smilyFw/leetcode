import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
    List<String> serializeList = new ArrayList<>();
    List<TreeNode> result = new ArrayList<>();
    List<String> done = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        if(serializeList.contains(sb.toString())){
            if(!done.contains(sb.toString())){
                result.add(root);
                done.add(sb.toString());
            }
        }else{
            serializeList.add(sb.toString());
        }
        findDuplicateSubtrees(root.left);
        findDuplicateSubtrees(root.right);
        return result;
    }

    private void serialize(TreeNode root, StringBuilder sb){
        String str = root == null ? "null" : String.valueOf(root.val);
        sb.append(str);
        if(root != null){
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }
}
// @lc code=end

