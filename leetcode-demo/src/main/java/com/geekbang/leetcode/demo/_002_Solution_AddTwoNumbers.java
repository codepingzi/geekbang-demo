package com.geekbang.leetcode.demo;

public class _002_Solution_AddTwoNumbers {


    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode currNode = headNode;

        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int val = val1 + val2 + carry;
            if (val >= 10){
                val = val % 10;
                carry = 1;
            }else{
                carry = 0;
            }
            currNode.next = new ListNode(val);
            currNode = currNode.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry > 0){
            currNode.next = new ListNode(carry);
        }

        return headNode.next;
    }
}
