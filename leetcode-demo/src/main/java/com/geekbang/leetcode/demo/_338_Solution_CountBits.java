package com.geekbang.leetcode.demo;

public class _338_Solution_CountBits {

    public static void main(String[] args) {
        _338_Solution_CountBits test = new _338_Solution_CountBits();
        test.countBits(10);
    }

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++){
            bits[i] = count(i);
        }
        return bits;
    }

    public int count(int x){
        int count = 0;
        while (x > 0){
            x = x & (x - 1);
            count++;
        }
        return count;
    }
}
