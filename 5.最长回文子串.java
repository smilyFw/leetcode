import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int tempMax = 0;
        int from = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            tempMax = midLen(s, i, 0);
            if (tempMax > max) {
                max = tempMax;
                from = i - (max - 1);
                end = i + max;
            }

            tempMax = midLen(s, i, 1);
            if (tempMax >= max) {
                max = tempMax;
                from = i - (max -1);
                end = i + max + 1;
            }
        }

        String result = s.substring(from, end);
        return result;
    }

    private int midLen(String s, int i, int k) {
        int midLen = 0;
        while (i - midLen >= 0 && i + k + midLen < s.length()) {
            if (s.charAt(i - midLen) == s.charAt(i + k + midLen)) {
                midLen++;
            } else {
                break;
            }
        }

        return midLen;
    }

}
