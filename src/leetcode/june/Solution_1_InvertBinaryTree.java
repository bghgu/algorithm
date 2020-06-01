package leetcode.june;

/**
 * Created by ccoli on 2020/06/01.
 */

public class Solution_1_InvertBinaryTree {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        invertTree(treeNode);
        invertTree(null);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        } else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        }
        return root;
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