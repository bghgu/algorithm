package leetcode.april;

/**
 * Created by ccoli on 2020/04/18.
 */

public class Solution_11_DiameterOfBinaryTree {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int max = -1;
        dfs(root);
        return 0;
    }

    private static void dfs(final TreeNode treeNode) {
        System.out.println(getDistance(treeNode, 0));
        if (treeNode.left != null) dfs(treeNode.left);
        if (treeNode.right != null) dfs(treeNode.right);
    }

    private static int getDistance(final TreeNode treeNode, int count) {
        if (treeNode.left != null) {
            count = Math.max(getDistance(treeNode.left, count + 1), count);
        }
        if (treeNode.right != null) {
            count = Math.max(getDistance(treeNode.right, count + 1), count);
        }
        return count;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(final int x) {
            val = x;
        }
    }
}