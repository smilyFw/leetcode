/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return;
        }

        int target = findTarget(nums);//从右到左，找到第一个比上一个小的数a[i]

        if(target == -1){
            reverse(nums, 0, len-1);//找不到，则说明没有符合条件的下一个排列了，直接反转
            return;
        }
        adjustTarget(nums, target);//从右到左，找到第一个比a[i]大的数，与a[i]交换位置
        reverse(nums, target+1, len-1);//将i+1后面的数反转一下，使之从小到大
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    
    private void adjustTarget(int[] nums, int targetIndex){//1
        int len = nums.length;
        for(int i = len-1; i >= 0; i--){
            if(nums[targetIndex] < nums[i]){//nums[1]<nums[2]
                swap(targetIndex, i, nums);//targetIndex = 1, i = 2
                break;
            }
        }
    }

    private void swap(int swapIndex1, int swapIndex2, int[] nums){
        int temp = nums[swapIndex1];
        nums[swapIndex1] = nums[swapIndex2];
        nums[swapIndex2] = temp;
    }

    private int findTarget(int[] nums){
        int len = nums.length;
    
        for(int i = len-1;  i > 0; i--){
            if(nums[i-1] < nums[i]){
                return i-1;
            }
        }
        return -1;
    }
}
// @lc code=end

