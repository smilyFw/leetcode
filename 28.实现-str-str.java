/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == ""){
            return 0;
        }

        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();

        int i = 0;
        int j = 0;
        int from = -1;
        while(i < need.length && j < hay.length){
            if(need[i] == hay[j]){
                i++;
                j++;
            }else{
                i=0;
                j=++from;
            }
        }

        if(i == need.length){
            return j-need.length;
        }else{
            return -1;
        }

    }
}
// @lc code=end

