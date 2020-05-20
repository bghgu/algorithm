package leetcode.may;

import java.util.PriorityQueue;

/**
 * Created by ccoli on 2020/05/20.
 */

public class Solution_20_KthSmallestElementInABST {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        System.out.println(kthSmallest(treeNode, 1));

    }

    private static PriorityQueue<Integer> queue;

    public static int kthSmallest(TreeNode root, int k) {
        queue = new PriorityQueue<>();
        search(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            count++;
            if (count == k) {
                return n;
            }
        }
        return count;
    }

    private static void search(TreeNode node) {
        if (node != null) {
            queue.offer(node.val);
            search(node.left);
            search(node.right);
        }
    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}