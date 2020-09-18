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
    public  List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> trace = new ArrayList<>();
        boolean[] reach = new boolean[nums.length];
        help(result, trace, reach, nums);
        return result;
    }

    private  void help(List<List<Integer>> result, List<Integer> trace, boolean[] reach, int[] nums){
        if(trace.size() == nums.length){
            result.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if(reach[i]){
                continue;
            }

            if(i > 0 && reach[i-1] && nums[i] == nums[i-1]){
                continue;
            }
            trace.add(nums[i]);
            reach[i] = true;
            help(result, trace, reach, nums);
            trace.remove(trace.size()-1);
            reach[i] = false;
        }
    }
}
// @lc code=end

