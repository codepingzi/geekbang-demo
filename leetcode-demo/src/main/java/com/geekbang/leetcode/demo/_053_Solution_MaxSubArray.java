package com.geekbang.leetcode.demo;

public class _053_Solution_MaxSubArray {

    public static void main(String[] args) {

    }

    private int maxSubArray1(int[] nums){
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] >= 0){
                maxSum += nums[i];
            }
        }

        return maxSum;
    }
}
