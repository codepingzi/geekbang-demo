package com.geekbang.leetcode.demo;

public class _053_Solution_MaxSubArray {

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        _053_Solution_MaxSubArray test = new _053_Solution_MaxSubArray();

        System.out.println(test.maxSubArray1(a));
    }

    private int maxSubArray1(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            if (dp[i - 1] <= 0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int maxSum = dp[0];
        for (int i = 1; i < len; i++){
            maxSum = Math.max(dp[i], dp[i - 1]);
        }

        return maxSum;
    }
}
