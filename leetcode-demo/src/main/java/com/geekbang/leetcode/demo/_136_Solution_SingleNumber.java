package com.geekbang.leetcode.demo;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class _136_Solution_SingleNumber {

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2,1,2};
        System.out.println(new _136_Solution_SingleNumber().singleNumber(a));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
