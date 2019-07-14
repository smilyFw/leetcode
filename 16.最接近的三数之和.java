import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
             return 0;
        }
        Arrays.sort(nums);
        return nCloesetSum(nums, 0, target, 3);
    }


    public int nCloesetSum(int [] nums, int startIndex, int target, int n){
        if(n == 2){
            return twoClosestSum(nums, startIndex, target);
        }else{
            int closest = 0;

            for(int i = startIndex; i < n; i++){
                closest += nums[i];
            }

            int temp = 0;
           for(int i = startIndex; i < nums.length-n+1; i++){
                 temp = nums[i]+ nCloesetSum(nums, i+1, target-nums[i], n-1);
                 if(Math.abs(temp-target) < Math.abs(closest - target)){
                      closest = temp;
                 }
           }
           return closest;
        }
    }
    public int twoClosestSum(int[] nums, int startIndex, int target){
        if(nums == null || nums.length == 0){
            return 0;
       }

       int left = startIndex;
       int right = nums.length -1;
       int closest = nums[left] + nums[right];
       int temp = 0;
       while(left < right){
           temp = nums[left] + nums[right];
           if(temp > target){
               right --;
           }else if(temp < target){
               left++;
           }else{
               return temp;
           }
           if(Math.abs(temp - target) < Math.abs(closest - target)){
               closest = temp;
           }
       }
       return closest;
    }
}

