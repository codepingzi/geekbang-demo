package com.geekbang.leetcode.demo;

import com.geekbang.leetcode.demo.ext.TreeNode;

public class _543_Solution_DiameterOfBinaryTree {

    public static void main(String[] args) {

    }

    int ans;

    public int diameterOfBinaryTree(TreeNode root){
        int ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node){
        if (node == null){
            return 0;
        }

        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
