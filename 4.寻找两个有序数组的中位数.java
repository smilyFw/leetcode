/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int index1  = 0;
            int index2 = 0;
            int mid2 = 0;
            int mid1 = 0;

            for(int i =0; i <= (m+n)/2; i++){
                mid1 = mid2;
                if(index1 == m){
                    mid2 = nums2[index2];
                    index2++;
                }else if(index2 == n){
                    mid2 = nums1[index1];
                    index1++;
                }else if(nums1[index1] > nums2[index2]){
                    mid2 = nums2[index2];
                    index2++;
                }else {
                    mid2 = nums1[index1];
                    index1++;
                }
            }

            if ((m+n) % 2 == 0){
                return (mid2+mid1)/2.0;
            }
            return mid2;
        
    }
}

