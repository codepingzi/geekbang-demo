package com.geekbang.leetcode.demo;

/**
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author yangweiping
 * @date 2022/3/8 下午2:11
 */
public class _005_Solution_LongestPalindrome {


    public static void main(String[] args) {
//        _005_Solution_LongestPalindrome test = new _005_Solution_LongestPalindrome();
//        String babad = test.longestPalindrome("a");
//
//        System.out.println(babad);


        System.out.println("abc".substring(0, 1));
        System.out.println("abc".substring(0, 2));
        System.out.println("abc".substring(0, 3));

    }

    public String longestPalindrome(String s){
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++){
            int end = i + 1;
            String tmpMaxPalindrome = "";
            while(end <= s.length()){
                String tmp = s.substring(i, end);
                if (this.check(tmp)) {
                    tmpMaxPalindrome = tmp;
                }
                end++;
            }
            if (tmpMaxPalindrome.length() > maxPalindrome.length()){
                maxPalindrome = tmpMaxPalindrome;
            }
        }
        return maxPalindrome;
    }

    private boolean check(String sub){
        int left = 0;
        int right = sub.length() - 1;

        while(left <= right){
            if (sub.charAt(left) != sub.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
