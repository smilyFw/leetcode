import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int tempIndex = 0;
        String tempStr = "";
        int resultIndex = 0;
        int j = 0;

        List<String> list = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            list.add("");
        }

        while (j < s.length()) {
            tempIndex = j % (numRows * 2 - 2 );
            if (tempIndex < numRows) {
                resultIndex = tempIndex;
            } else {
                resultIndex = numRows * 2 - 2 - tempIndex;
            }

            tempStr = list.get(resultIndex).concat(String.valueOf(s.charAt(j)));
            list.set(resultIndex, tempStr);
            j++;
        }

        String result = "";

        for (int i = 0; i < numRows; i++) {
            result = result.concat(list.get(i));
        }
        return result;
    }
}
