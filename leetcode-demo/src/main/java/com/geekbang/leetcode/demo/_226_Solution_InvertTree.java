package com.geekbang.leetcode.demo;

import com.geekbang.leetcode.demo.ext.TreeNode;

/**
 * @author yangweiping
 * @date 2022/3/3 下午1:52
 */
public class _226_Solution_InvertTree {

    public static void main(String[] args) {

    }

    /**
     * 反转 => 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmpTreeNode = root.left;
        root.left = root.right;
        root.right = tmpTreeNode;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 递归 => 反转
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
