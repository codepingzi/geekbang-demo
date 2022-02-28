package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/2/28 下午5:33
 */
public class _069_Solution_MySqrt {
    public static void main(String[] args) {
        _069_Solution_MySqrt test = new _069_Solution_MySqrt();
        System.out.println(test.mySqrt(232323232));
    }

    private int mySqrt(int x){
        int l = 0;
        int r = x >= 2 ? x / 2 : x;

        int and = 0;
        int sum = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x){
                and = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
            sum++;
        }

        System.out.println("计算次数="+ sum);

        return and;
    }
}
