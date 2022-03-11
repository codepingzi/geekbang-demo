package com.geekbang.acm.demo;

/**
 * @author yangweiping
 * @date 2022/3/10 下午6:11
 */
public class StringDemo {

    public static void main(String[] args) {
        String abc = "a";

        while (true){
            abc+=abc;
            System.out.println(abc.length());
        }
    }
}
