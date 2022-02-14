package com.geekbang.leetcode.demo;

public class _014_Solution_LongestCommonPrefix {

    public static void main(String[] args) {

    }

    /**
     * 解题思路
     * 1. 从高位到低位依次循环
     * @param strs
     * @return
     */
    public String solution_01(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        String commonPrefixStr = "";
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char c = str.charAt(i);
            commonPrefixStr = c.
        }


    }
}
