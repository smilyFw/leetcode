import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
           if(map.containsKey(temp)) {
                  return new int[]{map.get(temp), i};
            }else{
                map.put(target - temp, i);
            }
        }
        return null;
    }
}

