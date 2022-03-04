package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/3/3 下午3:38
 */
public class _234_Solution_IsPalindrome {

    public static void main(String[] args) {

        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        new _234_Solution_IsPalindrome().isPalindrome2(head);
    }


    /**
     * 递归方式
     * @param head
     * @return
     */
    public ListNode frontPointer;

    public boolean isPalindrome(ListNode head){
        frontPointer = head;
        return check(head);
    }

    public boolean check(ListNode currentNode){
        if (currentNode != null){
            if (!check(currentNode.next)){
                return false;
            }
            if (currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null){
            return true;
        }

        // 找到一半节点的位置
        ListNode firstHalfEndNode = endOfFirstHalf(head);
        // 反转后半部分
        ListNode secondHalfStart = reverseList(firstHalfEndNode.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        while(p2 != null){
            if (p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 反转第二部分, 可有可无, 如果保证不改变链接需要加上
        firstHalfEndNode.next = reverseList(secondHalfStart);
        return true;
    }

    /**
     * 反转指针
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 判断慢指针走到一半了
     * 两个指针, slow每次走一步, fast每次走两步,
     * 当fast走到尾部, slow走到中间位置
     * @param head
     * @return
     */
    private ListNode endOfFirstHalf(ListNode head){
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode.next != null && fastNode.next.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
