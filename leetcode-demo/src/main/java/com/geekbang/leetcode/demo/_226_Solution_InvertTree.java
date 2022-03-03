package com.geekbang.leetcode.demo;

import com.geekbang.leetcode.demo.ext.TreeNode;

/**
 * @author yangweiping
 * @date 2022/3/3 下午1:52
 */
public class _226_Solution_InvertTree {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }

        TreeNode tmpTreeNode = root.left;
        root.left = root.right;
        root.right = tmpTreeNode;

        if (root.left != null){
            invertTree(root.left);
        }

        if (root.right != null){
            invertTree(root.right);
        }

        return root;
    }
}
