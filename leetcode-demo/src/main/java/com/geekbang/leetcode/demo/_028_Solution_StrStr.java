package com.geekbang.leetcode.demo;

import com.alibaba.fastjson.JSON;

/**
 * "adcadcaddcadde"
 * "adcadde"
 */
public class _028_Solution_StrStr {

    public static void main(String[] args) {
        _028_Solution_StrStr test = new _028_Solution_StrStr();
        int[] ababs = test.maxSubStringLen("aabaaac");
        System.out.println(JSON.toJSONString(ababs));

//        int i = test.strStr1("abaaba", "aba");
//        System.out.println(i);
    }

    /**
     * KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr1(String haystack, String needle){
        if (needle.equals("")){
            return 0;
        }

        int[] next = maxSubStringLen(needle);

        int hLen = haystack.length();
        int nLen = needle.length();

        int j = 0;
        for (int i = 0; i < hLen; i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }

            if (j == nLen){
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] maxSubStringLen(String str){
        int[] next = new int[str.length()];
        for (int i = 1, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = next[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)){
                j++;
            }

            next[i] = j;
        }
        return next;
    }
}
