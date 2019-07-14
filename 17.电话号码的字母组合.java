import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */
class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] mapList = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        int i = 0;
        result.add("");
        
        while(i < digits.length()){
             result = combine(mapList[digits.charAt(i)-'1'], result);
             i++;
        }
        return result;
    }

    public static List<String>  combine(String newAdd, List<String> result){
        List<String> newResult = new ArrayList<>();

        for(int k = 0; k < newAdd.length(); k++){
           for (String item : result) {
                newResult.add(item + newAdd.charAt(k));
            }
        }
        return newResult;
    }
}

