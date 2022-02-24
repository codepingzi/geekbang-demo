package com.geekbang.leetcode.demo;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author yangweiping
 * @date 2022/2/23 下午4:05
 */
public class _021_Solution_MergeTwoList {

    public static void main(String[] args) {
        ListNode listNode14 = new ListNode(4);
        ListNode listNode12 = new ListNode(2, listNode14);
        ListNode listNode11 = new ListNode(1, listNode12);

        ListNode listNode24 = new ListNode(4);
        ListNode listNode23 = new ListNode(3, listNode24);
        ListNode listNode21 = new ListNode(1, listNode23);

        _021_Solution_MergeTwoList solution = new _021_Solution_MergeTwoList();
        ListNode listNode = solution.mergeTwoLists_01(listNode11, listNode21);
        solution.print(listNode);
    }

    private void print(ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 迭代方式
     * 1. 设计一个前置节点 preNode 其value=-1,
     * 2. 比较listNode1 和 listNode的首节点, value小的一个被前置节点preNode.next指向
     * 3. 然后移动前置节点指针为这个next节点,
     * 4. 继续比较指针的next节点和另一个listNode的首节点, 直到后面节点为null
     * 5. 返回第二个节点的listNode
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode mergeTwoLists_01(ListNode listNode1, ListNode listNode2) {
        ListNode preHead = new ListNode(-1);
        ListNode preNode = preHead;
        while(listNode1 != null && listNode2 != null){
            if (listNode1.val <= listNode2.val){
                preNode.next = listNode1;
                listNode1 = listNode1.next;
            }else{
                preNode.next = listNode2;
                listNode2 = listNode2.next;
            }
            preNode = preNode.next;
        }

        preNode.next = listNode1 != null ? listNode1 : listNode2;
        return preHead.next;
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
