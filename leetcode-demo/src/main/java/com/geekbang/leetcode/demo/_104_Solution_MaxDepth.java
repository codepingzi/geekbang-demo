package com.geekbang.leetcode.demo;

import com.geekbang.leetcode.demo.ext.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _104_Solution_MaxDepth {

    public static void main(String[] args) {

    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root){
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
