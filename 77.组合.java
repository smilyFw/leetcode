import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */
class Solution {
    private int n = 0;
    private int k = 0;
    public List<List<Integer>> combine(int n, int k) {
       this.n = n;
       this.k = k;
       List<Integer> target = new ArrayList<>();
       List<List<Integer>> result = new ArrayList<>();
       for(int i = 1; i <= n ; i++){
            target.add(i);
       }
       helper(result, new ArrayList(), target);
       return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> selected, List<Integer> target){
        
        if(target.size() == 0 && selected.size() < k){
            return;
        }else if(selected.size() == k){
            result.add(selected);
            return;
        }

        for(int  i = 0; i < target.size(); i++){
            List<Integer> tempSelect = new ArrayList<>();
            tempSelect.addAll(selected);
            tempSelect.add(target.get(i));

            List<Integer> tempTarget = new ArrayList<>();
            for(int j = i+1; j < target.size(); j++){
                tempTarget.add(target.get(j));
            }

            helper(result, tempSelect, tempTarget);
        }
    }
}

