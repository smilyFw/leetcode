import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mapMap = new HashMap<>();
        mapMap.put(']', '[');
        mapMap.put('}', '{');
        mapMap.put(')', '(');

        boolean legal = false;
        Stack<Character> stack = new Stack<Character>();
        char[] a = s.toCharArray();
        for(char item:a){
            if(mapMap.values().contains(item)){
                stack.push(item);
            }else{
                if(!stack.isEmpty()){
                    legal = stack.pop().equals(mapMap.get(item));
                }else{
                    legal = false;
                }
                if(!legal){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
