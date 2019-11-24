/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {

    public int mySqrt(int x){
        long i = 0;
        long j = x/2+1;//负数的平方根不可能大于x/2+1  3
        long mid = 0;
        long res = 0;
        while(i <= j){ //0<3
            mid=(i+j)/2;//1 | 2 | 3 | 2
            res = mid * mid; //1 | 4 | 9 | 4
            if(res == x){
                return (int)mid;
            }else if(res > x){
                j = mid -1; // 2
            }else {
                i = mid + 1;//2 | 3 | 4
            }
        }
        return (int)j;
    }


    public int mySqrt1(int x) {
        long temp = x;
        while(temp * temp > x){
            temp = binarySearch(0, temp);
        }

        while((temp+1)*(temp+1)<=x){
            temp+=1;
        }
        return (int)temp;
    }

    public long binarySearch(long x, long y){
         if((x+y)%2==0){
            return(x+y)/2;
         }else{
            return (x+y)/2+1;
         }
    }
}
// @lc code=end

