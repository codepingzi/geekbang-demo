package com.geekbang.acm.demo;

import java.util.Scanner;

public class Sum_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            int sum = 0;
            for (String s1 : s){
                sum += Integer.parseInt(s1);
            }
            System.out.println(sum);
        }



    }
}
