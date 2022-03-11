package com.geekbang.algorithms.dp;

/**
 * @author yangweiping
 * @date 2022/3/11 上午10:21
 */
public class Test01 {

    int sum = 0;

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int n = 10;
        int[] memo = new int[n + 1];
        int fibonacci = test01.fibonacci(n, memo);


        System.out.println("循环次数=" + test01.sum);
        System.out.println("fibonacci=" + fibonacci);

    }

    private int fibonacci(int n, int[] memo){
        if (n == 0 || n == 1){
            return n;
        }

        if (memo[n] != 0){
            return memo[n];
        }

        if(n > 1){
            sum++;
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            return memo[n];
        }
        return 0;
    }
}
