package com.leikoooo.charpter16_slide.level2;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLenTwo(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int minSubArrayLenTwo(int target, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int left = 0, right = 0;
        int result = Integer.MAX_VALUE; // 初始化为一个足够大的数
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
