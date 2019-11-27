/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length  == 0){
            return -1;
        }

        if(nums.length == 1){
            return nums[0];
        }
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
// @lc code=end

