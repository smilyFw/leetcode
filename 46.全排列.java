/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    static int len = 0;
 
     public static void main(String[] args) {
         int[] arr = {1,2,3};
         permute(arr);
     }
     public static List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> list = new ArrayList<>();
         len = nums.length;
 
         List<Integer> select = new ArrayList<>();
         for (int i = 0; i < nums.length; i++){
             select.add(nums[i]);
         }
         helper(list, select, new ArrayList<>());
 
         return list;
 
     }
 
     private  static void helper(List<List<Integer>> list,  List<Integer> selectList, List<Integer> resultList){
         if (resultList.size() == len){
             list.add(resultList);
             return;
         }
 
         List<Integer> tempSelectList = null;
         List<Integer> tempResultList = null;
         Integer temp = 0;
         for (int i = 0; i < selectList.size(); i++){
             temp = selectList.get(i);
             tempSelectList = new ArrayList<>();
             tempSelectList.addAll(selectList);
             tempSelectList.remove(temp);
 
             tempResultList = new ArrayList<>();
             tempResultList.addAll(resultList);
             tempResultList.add(temp);
 
             helper(list, tempSelectList, tempResultList);
         }
     }
 }
// @lc code=end

