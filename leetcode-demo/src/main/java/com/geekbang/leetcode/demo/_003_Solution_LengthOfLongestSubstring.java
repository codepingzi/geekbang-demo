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
        _003_Solution_LengthOfLongestSubstring test = new _003_Solution_LengthOfLongestSubstring();
        int i = test.lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        if (s.length() == 0){
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap();
        int flag = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(charIndexMap.containsKey(c)){
                flag = Math.max(flag, charIndexMap.get(c) + 1);
            }
            max = Math.max(max, i - flag + 1);
            charIndexMap.put(c, i);
        }
        return max;
    }
}
