import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();

        if(nums == null || nums.length == 0){
            return resultList;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        for(int i = 0; i < nums.length - 2; i++){
            left = i+1;
            right = nums.length-1;

            while(left < right){

                if(nums[i] + nums[left] + nums[right] > 0){
                    right --;
                }else if(nums[i]+nums[left] +nums[right] < 0 ){
                    left ++;
                }else{
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }

            while (i < nums.length - 3 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return resultList;
    }
}

