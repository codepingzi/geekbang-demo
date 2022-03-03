package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/3/3 上午10:23
 */
public class _206_Solution_ReverseList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head){

        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
