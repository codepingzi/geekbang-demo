package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/2/28 下午3:32
 */
public class _058_Solution_LengthOfLastWord {


    public static void main(String[] args) {
        _058_Solution_LengthOfLastWord test = new _058_Solution_LengthOfLastWord();

        System.out.println(test.lengthOfLastWord2("a"));

    }


    private int lengthOfLastWord(String s){
        String[] split = s.trim().split("");
        return split[split.length - 1].length();
    }

    private int lengthOfLastWord2(String s){
        int lastWordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (' ' == s.charAt(i) && lastWordLength == 0){
                continue;
            }

            if (' ' != s.charAt(i)){
                lastWordLength++;
            }

            if (' ' == s.charAt(i) && lastWordLength > 0){
                break;
            }
        }
        return lastWordLength;
    }
}
