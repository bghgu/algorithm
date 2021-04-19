package leetcode.medium;

/**
 * Created by ds on 2021/04/16
 * https://leetcode.com/problems/maximum-binary-tree/
 */

public class Solution_654 {

    public static void main(String... args) {
        int[] arr1 = {3, 2, 1, 6, 0, 5};
        int[] arr2 = {3, 2, 1};
        constructMaximumBinaryTree(arr1);
        //constructMaximumBinaryTree(arr2);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode treeNode = new TreeNode();

        getMaxValue(treeNode, nums, 0, nums.length - 1);

        search(treeNode);

        return treeNode;
    }

    private static void getMaxValue(TreeNode treeNode, final int[] nums, final int start, final int end) {
        int max = -1;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        treeNode.val = max;

        if (start <= index - 1) {
            treeNode.left = new TreeNode();
            getMaxValue(treeNode.left, nums, start, index - 1);
        }

        if (index + 1 <= end) {
            treeNode.right = new TreeNode();
            getMaxValue(treeNode.right, nums, index + 1, end);
        }
    }

    private static void search(final TreeNode treeNode) {
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            search(treeNode.left);
        }
        if (treeNode.right != null) {
            search(treeNode.right);
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

    /**
     * you are given an integer array nums with no duplicates.
     *
     * A maximum binary tree can be built recursively from nums using the following algorithm.
     *
     * 1. create a root node whose value is the maximum value in nums.
     * 2. recursively build the left subtree on the subarray prefix to the left of the maximum value.
     * 3. recursively build the right subtree on the subarray suffix to the right of the maximum value.
     *
     * return the maximum binary tree built from nums.
     */
}