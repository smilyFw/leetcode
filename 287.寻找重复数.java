import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    //[3,1,3,4,2]
    public int findDuplicate(int[] nums) {
        int len = nums.length; // 5
        int right = len-1;// 4
        int left = 0;

         int mid = 0;
         int count = 0;
         while(left < right){// 0 < 4 | 3 < 4
             mid = (right - left) / 2 + left; // 2 | 3

             for(int i = 0; i < len; i++){
                 if(nums[i] <= mid){
                      count++;
                 }
             }

             if(count <= mid){// 2 <= 2 
                 left = mid + 1; // 3
             }else{ // 4 > 3
                 right = mid; // 3
             }
             count = 0;
         }
         return left;
       }
}
// @lc code=end

