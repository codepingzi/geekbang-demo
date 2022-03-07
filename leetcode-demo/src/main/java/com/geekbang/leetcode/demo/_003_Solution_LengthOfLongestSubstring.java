package com.geekbang.leetcode.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author yangweiping
 * @date 2022/3/7 上午10:59
 */
public class _003_Solution_LengthOfLongestSubstring {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s){
        if (s.length() == 0){
            return 0;
        }

        Set<Character> existChar = new HashSet<>();
        int left = 0;
        int maxSubStringLength = 0;
        for (int i = 0; i < s.length(); i++){

            if(!existChar.contains(s.charAt(i))){
                existChar.put(s.charAt(i), i);
            }else{
                maxSubStringLength = Math.max(existChar.size(), maxSubStringLength);

            }
        }
    }
}
