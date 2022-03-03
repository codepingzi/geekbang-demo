package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/3/3 下午3:38
 */
public class _234_Solution_IsPalindrome {

    public static void main(String[] args) {



    }


    public boolean isPalindrome(ListNode head){

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }

}
