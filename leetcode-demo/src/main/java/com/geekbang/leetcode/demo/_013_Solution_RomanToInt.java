package com.geekbang.leetcode.demo;

import java.util.HashMap;
import java.util.Map;

public class _013_Solution_RomanToInt {

    public static void main(String[] args) {
        String s = "IV";
        int i = new _013_Solution_RomanToInt().solution_02(s);
        System.out.println(i);
    }

    private int solution_02(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        Map<Character, Integer> romanNumMap = new HashMap<>();
        romanNumMap.put('I', 1);
        romanNumMap.put('V', 5);
        romanNumMap.put('X', 10);
        romanNumMap.put('L', 50);
        romanNumMap.put('C', 100);
        romanNumMap.put('D', 500);
        romanNumMap.put('M', 1000);

        int length = s.length();
        int num = 0;
        for (int i = 0; i < length; i++) {
            int currNum = romanNumMap.get(s.charAt(i));
            if (i < length - 1 && currNum < romanNumMap.get(s.charAt(i + 1))) {
                num += -currNum;
            } else {
                num += currNum;
            }
        }

        return num;
    }

    private int solution_01(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        Map<Character, Integer> romanNumMap = new HashMap<>();
        romanNumMap.put('I', 1);
        romanNumMap.put('V', 5);
        romanNumMap.put('X', 10);
        romanNumMap.put('L', 50);
        romanNumMap.put('C', 100);
        romanNumMap.put('D', 500);
        romanNumMap.put('M', 1000);

        int[] numArr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int currNum = romanNumMap.get(c);
            numArr[i] = currNum;
            if (i > 0) {
                int preIndex = i - 1;
                int preNum = numArr[preIndex];
                if (preNum < currNum) {
                    numArr[i] = currNum - preNum;
                    numArr[preIndex] = 0;
                }
            }
        }

        int num = 0;
        for (int i = 0; i < numArr.length; i++) {
            num += numArr[i];
        }
        return num;
    }
}
