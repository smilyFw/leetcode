import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        int temp = 0;
        List<List<Integer>> tempResult = null;
        for (int i = 0; i < nums.length - 3; i++) {
            temp = nums[i];
            tempResult = threeSum(nums, i + 1, target - temp);
            if (tempResult.size() > 0) {
                for (List<Integer> item : tempResult) {
                    result.add(Arrays.asList(temp, item.get(0), item.get(1), item.get(2)));
                }
            }

            while (i < nums.length - 4 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;

    }

    public List<List<Integer>> threeSum(int[] nums, int startIndex, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int temp = 0;
        int left = 0;
        int right = 0;
        for (int i = startIndex; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                temp = nums[i] + nums[left] + nums[right];
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }

            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;

    }
}
