package leetcode.june;

/**
 * Created by ccoli on 2020/06/15.
 */

public class Solution_15_SearchInABinarySearchTree {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        System.out.println(searchBST(treeNode, 2));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode treeNode = root;
        while (treeNode != null) {
            if (treeNode.val < val) {
                treeNode = treeNode.right;
            }else if (treeNode.val > val) {
                treeNode = treeNode.left;
            }else {
                return treeNode;
            }
        }
        return null;
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