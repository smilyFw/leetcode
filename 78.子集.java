import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> itemList = null;
        List<Integer> newItemList = null;
        result.add(new ArrayList<Integer>());

        int size = 0;
        for(int i = 0; i < nums.length; i++){
            size = result.size();
            for(int j = 0; j < size;j++){
               itemList = result.get(j);
               newItemList = new ArrayList<>();
               if(itemList.size()>0){
                   newItemList.addAll(itemList);
               }
               newItemList.add(nums[i]);
               result.add(newItemList);
            }
        }
        return result;
    }
}

