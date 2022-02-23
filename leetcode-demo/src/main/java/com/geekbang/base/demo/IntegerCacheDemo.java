package com.geekbang.base.demo;

public class IntegerCacheDemo {

    public static void main(String[] args) {
        Integer a = 40;
        Integer b = 40;
        Integer c = new Integer(40);

        Integer e = 128;
        Integer f = 128;

        Integer g = 127;
        Integer h = 127;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(e == f);
        System.out.println(g == h);

    }
}
