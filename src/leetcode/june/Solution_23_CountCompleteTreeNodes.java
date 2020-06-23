package leetcode.june;

/**
 * Created by ccoli on 2020/06/23.
 */

public class Solution_23_CountCompleteTreeNodes {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        System.out.println(countNodes(treeNode));
        System.out.println(countNodes(null));
    }

    private static int count = 0;

    public static int countNodes(TreeNode root) {
        count = 0;
        func(root);
        return count;
    }

    private static void func(TreeNode treeNode) {
        if (treeNode != null) {
            count++;
            if (treeNode.left != null) {
                func(treeNode.left);
            }
            if (treeNode.right != null) {
                func(treeNode.right);
            }
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