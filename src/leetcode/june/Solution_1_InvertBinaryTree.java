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
    }

    public static TreeNode invertTree(TreeNode root) {
        root.change();
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

        public void change() {
            if (this.left != null && this.right != null) {
                TreeNode temp = this.left;
                this.left = this.right;
                this.right = temp;
                this.left.change();
                this.right.change();
            } else if (this.left != null && this.right == null) {
                this.right = this.left;
                this.left = null;
                this.right.change();
            } else if (this.left == null && this.right != null) {
                this.left = this.right;
                this.right = null;
                this.left.change();
            }
        }
    }
}