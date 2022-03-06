package com.geekbang.leetcode.demo;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class _461_Solution_HanmingDistance {

    public static void main(String[] args) {
        System.out.println(5 ^ 8);
        System.out.println(10 ^ 8);
        System.out.println(90 ^ 8);
        System.out.println(89 ^ 89);
        System.out.println(5 ^ 8);
    }

    /**
     * Brian Kernighan
     * @param x
     * @param y
     * @return
     */
    public int hanmingDistance(int x, int y){
        long n = (long) x ^ y;
        int ans = 0;
        while (n >= 0){
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    /**
     * 位移运算
     * @param x
     * @param y
     * @return
     */
    public int hanmingDistanc2(int x, int y){
        int n = x ^ y;
        int ans = 0;
        while (n > 0){
            // 与1运算, 最后一位为1+1
            ans += n & 1;
            // 右移1位
            n >>= 1;
        }
        return ans;
    }

    /**
     * 内置计算器
     * @param x
     * @param y
     * @return
     */
    public int hanmingDistanc3(int x, int y){
        return Integer.bitCount(x ^ y);
    }




}
