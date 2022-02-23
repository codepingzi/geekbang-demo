package com.geekbang.leetcode.demo;

public class _014_Solution_LongestCommonPrefix {


    public static void main(String[] args) {
        String[] ab = new String[]{"cir","car"};
        _014_Solution_LongestCommonPrefix sub = new _014_Solution_LongestCommonPrefix();

        System.out.println(sub.solution_02(ab));
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

        if (strs.length == 1){
            return strs[0];
        }

        int minStrLength = 200;
        for (String str: strs) {
            minStrLength = Math.min(str.length(), minStrLength);
        }

        StringBuffer commonPrefixStr = new StringBuffer();
        char currStr = 0;
        for (int j = 0; j < minStrLength; j++){
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char c = str.charAt(j);
                if (i == 0){
                    currStr = c;
                }else{
                   if (currStr != c){
                       return commonPrefixStr.toString();
                   }

                   if (i == strs.length - 1){
                       commonPrefixStr.append(c);
                   }
                }
            }
        }
        return commonPrefixStr.toString();
    }

    public String solution_02(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }

        int length = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < length; i++){
            for (int j = 1; j < count; j++){
                char c = strs[0].charAt(i);
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
}
