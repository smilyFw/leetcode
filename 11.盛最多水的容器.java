
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int result = 0;
        int max = 0;

        int i = 0;
        int j = len - 1;
        int target = 0;
        while(i < j){
            max = Math.min(height[i], height[j]) * (j-i);
            if(result < max){
                result = max;
           }
            if(height[i]> height[j]){
                target = height[j];
                j--;
                while((height[j] < target) && j > i){
                     j--;
                }
            }else{
                target = height[i];
                i++;
                while(height[i] < target && i < j){
                     i++;
                }
            }
        }
        return result;
    }
}

