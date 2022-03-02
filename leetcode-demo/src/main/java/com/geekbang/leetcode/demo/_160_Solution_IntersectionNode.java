package com.geekbang.leetcode.demo;

/**
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author yangweiping
 * @date 2022/3/2 下午1:34
 */
public class _160_Solution_IntersectionNode {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(1);
        ListNode node1 = new ListNode(2, node2);

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4, node3);

        ListNode headA = node1;
        ListNode headB = node1;

        _160_Solution_IntersectionNode test = new _160_Solution_IntersectionNode();
        ListNode intersectionNode = test.getIntersectionNode2(node1, node4);


    }

    /**
     * 1. 存在相交的节点, A节点
     * 2. 不存在相交的节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;
        ListNode firstEndNode = null;

        int i = 0;
        while(currA != null && currB != null){
            if (i == 2){
                if (currA.equals(currB)){
                    return currA;
                }
            }

            // 两个节点长度一致
            if (currA.next == null && currB.next == null){
                // 无相交节点
                if (!currA.equals(currB)){
                    return null;
                }
                currA = headA;
                currB = headB;
                i += 2;
            }
            // A节点走到尾部
            else if (currA.next == null){
                if (firstEndNode == null){
                    firstEndNode = currA;
                }else if (!firstEndNode.equals(currA)){
                    return null;
                }
                currA = headB;
                currB = currB.next;
                i++;
            }

            // B节点走到尾部
            else if (currB.next == null){
                if (firstEndNode == null){
                    firstEndNode = currB;
                }else if (!firstEndNode.equals(currB)){
                    return null;
                }
                currB = headA;
                currA = currA.next;
                i++;
            }else {
                currB = currB.next;
                currA = currA.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
