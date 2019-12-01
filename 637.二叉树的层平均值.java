import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(root);

        List<Double> result = new ArrayList<>();
        TreeNode temp = null;
        int size = 0;
        double sum = 0;
        int i = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(i = 0; i < size; i++){
                temp = queue.poll();
                sum+=temp.val;
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            result.add((double)(sum*1.0/i));
            sum = 0;
        }
        return result;
    }
}
// @lc code=end

