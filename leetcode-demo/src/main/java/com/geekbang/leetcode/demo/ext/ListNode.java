package com.geekbang.leetcode.demo.ext;

/**
 * @author yangweiping
 * @date 2022/3/1 下午1:07
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
