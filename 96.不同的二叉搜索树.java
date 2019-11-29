import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
               arr[i] += arr[j] * arr[i-1-j];
            }
        }
        return arr[n];
    }
}
// @lc code=end

