package com.geekbang.leetcode.demo;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _009_Solution_PalindromeNumber {


    public static void main(String[] args) {
//
//        int arg = 123;
//        boolean b = new _009_Solution_PalindromeNumber().solution_01(arg);
//        System.out.println("PalindromeNumber:[" + arg + "] is: " + b);

        int arg = 12321;
        boolean b = new _009_Solution_PalindromeNumber().solution_02(arg);
        System.out.println("PalindromeNumber[" + arg + "] is: " + b);


    }

    private boolean solution_03(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0)){
            return false;
        }
        int revertedNumber = 0;
        while(num > revertedNumber){
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }
        return num == revertedNumber || num == revertedNumber / 10;
    }

    private boolean solution_02(int num) {

        if (num < 0){
            return false;
        }else if(num < 10){
            return true;
        }

        String numStr = Integer.toString(num);
        int[] intArr = new int[numStr.length()];
        int length = intArr.length;
        int rightStart = length / 2 + length % 2;


        String substringLeft = numStr.substring(0, length / 2);
        String substringRight = numStr.substring(rightStart, length);

        String reverseLeft = new StringBuffer(substringLeft).reverse().toString();
        return reverseLeft.equals(substringRight);
    }

    private boolean solution_01(int num) {

        if (num < 0){
            return false;
        }

        String numStr = Integer.toString(num);
        int[] intArr = new int[numStr.length()];
        int length = intArr.length;
        int middle = length / 2;

        for (int i = 0; i < middle; i++) {
            char l = numStr.charAt(i);
            char r = numStr.charAt(length - 1 - i);
            if (l != r) {
                return false;
            }
            return true;
        }
        return true;
    }
}
