import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backstrack(list, "", 0, 0, n);
        return list;
    }

    public void backstrack(List<String> list, String s, int left, int right,int max){
        if(left > max || right > max){
            return;
        }

        if(left == max && right == max){
              list.add(s);
        }

        if(left >= right){
            backstrack(list, s+"(", left+1, right, max);
            backstrack(list, s+")", left, right+1, max);
        }
    }
}

