package com.geekbang.leetcode.demo;

import com.geekbang.leetcode.demo.ext.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class _101_Solution_IsSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);

        root.left = node21;
        root.right = node22;

        TreeNode node31 = new TreeNode(5);
        TreeNode node32 = new TreeNode(3);

        node21.left = node31;
        node21.right = node32;

        TreeNode node33 = new TreeNode(3);
        TreeNode node34 = new TreeNode(5);

        node22.left = node33;
        node22.right = node34;


        TreeNode node41 = new TreeNode(7);
        TreeNode node42 = new TreeNode(8);

        node32.left = node41;
        node32.right = node42;

        TreeNode node43 = new TreeNode(8);
        TreeNode node44 = new TreeNode(7);

        node33.left = node43;
        node33.right = node44;

        _101_Solution_IsSymmetric test = new _101_Solution_IsSymmetric();

        boolean symmetric2 = test.isSymmetric2(root);
        System.out.println(symmetric2);

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if(left == null){
            return false;
        }else if(right == null){
            return false;
        }else if (left.val != right.val){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
