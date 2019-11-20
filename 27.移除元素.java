/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
    
        int curLoc = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[curLoc] = nums[i];
                curLoc ++;
            }
        }
        return curLoc;
    }
}
// @lc code=end

