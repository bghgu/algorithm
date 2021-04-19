package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2021/04/11.
 * https://leetcode.com/problems/deepest-leaves-sum/
 */

public class Solution_1302 {

    public static void main(String... args) {

    }

    private static List<Pair> list = new LinkedList<>();
    private static int childDepth = 0;

    public static int deepestLeavesSum(TreeNode root) {
        list = new LinkedList<>();
        childDepth = 0;
        int sum = 0;
        search(root, 0);
        for (Pair pair : list) {
            if (pair.depth == childDepth) {
                sum += pair.value;
            }
        }
        return sum;
    }

    private static class Pair {
        private int value;
        private int depth;

        public Pair(final int value, final int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    public static void search(TreeNode now, final int depth) {
        if (now.left == null && now.right == null) {
            childDepth = Math.max(childDepth, depth);
            list.add(new Pair(now.val, depth));
        }
        if (now.left != null) {
            search(now.left, depth + 1);
        }
        if (now.right != null) {
            search(now.right, depth + 1);
        }
    }

    public class TreeNode {
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

    /**
     * given the root of a binary tree, return the sum of values of its deepest leaves
     */
}