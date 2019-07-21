import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import java.util.LinkedList;



/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

       if(root == null){
           return result;
       }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.offer(root);
       TreeNode temp = null;
       List<Integer> levelList = null;

       while(!queue.isEmpty()){
           int queueSize = queue.size();
           levelList = new ArrayList<Integer>();
           
           for(int i = 0; i < queueSize; i++){
            temp = queue.poll();
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right!= null){
                queue.offer(temp.right);
            } 
            levelList.add(temp.val);
           }
            result.add(levelList);
       }
       return result;
    }
}

