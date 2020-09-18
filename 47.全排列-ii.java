/*
 * @lc app=leetcode.cn id=47 lang=java
 *给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *示例:
 *输入: [1,1,2]
 *输出:
 *[
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 *]
 */

// @lc code=start
class Solution {
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> trace = new ArrayList<>();
        helper(result, nums, trace, nums.length);
        return result;
    }

    private void helper(List<List<Integer>> result,int[] nums, List<Integer> trace, int len){
        if(trace.size() == len){
            result.add(new ArrayList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(trace.contains(nums[i])){
                continue;
            }
            trace.add(nums[i]);
            helper(result, nums, trace, len);
            trace.remove(trace.size()-1);
        }
    }
}
// @lc code=end

