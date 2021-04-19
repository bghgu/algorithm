package leetcode.medium;

/**
 * Created by ds on 2021/04/19
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */

public class Solution_1008 {

    public static void main(String... args) {
        int[] arr1 = new int[]{8, 5, 1, 7, 10, 12};
        System.out.println(bstFromPreorder(arr1));
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            insert(root, value);
        }

        search(root);

        return root;
    }

    public static void insert(TreeNode treeNode, final int value) {
        if (treeNode.val < value) {
            if (treeNode.right == null) {
                treeNode.right = new TreeNode(value);
            }else {
                insert(treeNode.right, value);
            }
        } else {
            if (treeNode.left == null) {
                treeNode.left = new TreeNode(value);
            }else {
                insert(treeNode.left, value);
            }
        }
    }

    public static void search(TreeNode treeNode) {
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
     * given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
     *
     * it is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
     *
     * a binary search tree is a binary tree where for every node, any descendant of node.left has a value strictly less than node.val, and
     * any descendant of node.right has a value strictly greater than node.val
     *
     * a preorder traversal of a binary tree displays the value of the node first, then traverse node.left, then traverses node.right
     */
}