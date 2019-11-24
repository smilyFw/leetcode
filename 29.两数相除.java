/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start

//10/3
class Solution {
    public static void main(String[] args){
        divide(12,3);
    }
    public static int divide(int dividend, int divisor) {
        boolean same = dividend > 0 && divisor > 0 
        || dividend < 0 && divisor < 0;

        dividend = (dividend > 0) ? 0- dividend : dividend;//-10 |-12
        divisor = (divisor > 0) ? 0- divisor : divisor;//-3 | -3

        if(divisor < dividend){  // -3 < -10 | -3 < -12
            return 0;
        }
        long result = 0;
        long index = 1;
        long temp = divisor;
        while(temp >= dividend && dividend < 0){  // -3,-10 | -6,-10 | -3 ,-12
            temp = temp << 1;  // -6 | -12 | -6 | -12
            index = index << 1; //2 | 2 | 4
            if (temp == dividend) {
                result +=index;
                break;
            } else if(temp < dividend){ // 
                temp = temp >> 1; //-6
                dividend = (int)(dividend - temp);//-4
                result += index >> 1;
                temp = divisor;
                index = 1;
            }
        }
        result =  same ? result : 0 - result;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)result;
    }
}
// @lc code=end

