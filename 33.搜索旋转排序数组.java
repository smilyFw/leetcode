/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return bf(nums, 0, nums.length-1, target);
    }

    private int bf(int[] nums,int from, int end, int target){
        if(from == end){
            if(nums[from] == target){
                return from;
            }else{
                return -1;
            }

        }else if (from > end){
            return -1;
        }

        int midIndex = from + (end-from) / 2;
        int mid = nums[midIndex];
        int l, r = 0;

        if(target == mid){
            return midIndex;
        }else{
            if(nums[from] <= mid){
                if(target < mid &&  target >= nums[from]){
                    l = from;
                    r = midIndex-1;
                }else{
                    l = midIndex + 1;
                    r = end;
                }
            }else {
                if(target > mid && target <= nums[end]){
                    l = midIndex+1;
                    r = end;
                }else{
                    l = from;
                    r = midIndex-1;
                }
            }
        }
        return bf(nums, l, r, target);
    }
}
// @lc code=end

