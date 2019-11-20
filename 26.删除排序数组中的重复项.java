/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
    
        int curLoc = 1;
        int len = nums.length;
        for(int i = 1; i < len; i++){
             if(nums[i] > nums[curLoc-1]){
                nums[curLoc] = nums[i];
                curLoc ++;
             }
        }
        return curLoc;
    }
}
// @lc code=end

