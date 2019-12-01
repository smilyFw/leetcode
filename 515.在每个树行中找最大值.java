import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);

        TreeNode temp = null;
        int max = list.peek().val;
        List<TreeNode> tempList = new ArrayList<>();
        while(!list.isEmpty()){
            temp = list.poll();
            max = Math.max(max, temp.val);

            if(temp.left!=null){
                tempList.add(temp.left);
            }
            if(temp.right!= null){
                tempList.add(temp.right);
            }
            if(list.isEmpty()){
                list.addAll(tempList);
                tempList = new ArrayList<>();
                result.add(max);
                max = list.isEmpty() ? 0 : list.peek().val;
            }
        }
        return result;
    }
}
// @lc code=end

