package leetcode.medium;

/**
 * Created by ds on 2021/04/12.
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

public class Solution_1038 {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(3);

        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);
        System.out.println(bstToGst(treeNode));
    }

    private static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;

        search(root);

        return root;
    }

    private static void search(TreeNode now) {
        if (now.right != null) {
            search(now.right);
        }
        sum = now.val = sum + now.val;
        if (now.left != null) {
            search(now.left);
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
     * given the root of a binary search tree (BST), convert it to a greater tree such that
     * every key of the original BST is changed to the original key plus sum of all keys greater than
     * the original key in BST
     *
     * as a remainder, a binary search tree is a tree that satisfies these constraints:
     *
     * the left subtree of a node contains only nodes with keys less than the node`s key.
     *
     * the right subtree of a node contains only nodes with keys greater than the node`s key.
     *
     * both the left and right subtree must also be binary search trees.
     *
     *
     */
}