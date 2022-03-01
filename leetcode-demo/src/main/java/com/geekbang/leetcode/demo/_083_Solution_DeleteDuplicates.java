package com.geekbang.leetcode.demo;

import com.geekbang.leetcode.demo.ext.ListNode;

/**
 * @author yangweiping
 * @date 2022/3/1 下午1:05
 */
public class _083_Solution_DeleteDuplicates {


    public static void main(String[] args) {

       ListNode listNode5 = new ListNode(5);
       ListNode listNode4 = new ListNode(4, listNode5);
       ListNode listNode3 = new ListNode(3, listNode4);
       ListNode listNode2 = new ListNode(3, listNode3);
       ListNode listNode1 = new ListNode(2, listNode2);
       ListNode listNode0 = new ListNode(2, listNode1);

        _083_Solution_DeleteDuplicates test = new _083_Solution_DeleteDuplicates();

        ListNode listNode = test.deleteDuplicates(listNode0);

        test.print(listNode);

    }

    private void print(ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return null;
        }

        ListNode currNode = head;
        while(currNode.next != null){
            if (currNode.val == currNode.next.val){
                currNode.next = currNode.next.next;
            }else{
                currNode = currNode.next;
            }
        }
        return head;
    }
}


