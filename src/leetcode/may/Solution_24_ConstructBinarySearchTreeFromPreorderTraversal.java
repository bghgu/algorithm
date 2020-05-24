package leetcode.may;

/**
 * Created by ccoli on 2020/05/24.
 */

public class Solution_24_ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String... args) {
        bstFromPreorder(new int[] {8, 5, 1, 7, 10, 12});
    }

    private static TreeNode root = null;

    public static TreeNode bstFromPreorder(int[] preorder) {
        root = null;
        for (int i : preorder) {
            if (root == null) {
                root = new TreeNode(i);
            }else {
                TreeNode treeNode = root;
                while (true) {
                    if (treeNode.val > i) {
                        if (treeNode.left == null) {
                            treeNode.left = new TreeNode(i);
                            System.out.println();
                            break;
                        }else {
                            treeNode = treeNode.left;
                        }
                    }else {
                        if (treeNode.right == null) {
                            treeNode.right = new TreeNode(i);
                            break;
                        }else {
                            treeNode = treeNode.right;
                        }
                    }
                }
            }
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

        void preorder() {
            System.out.println(this.val);
            if (this.left == null) {
                System.out.println("null");
            }else {
                this.left.preorder();
            }
            if (this.right == null) {
                System.out.println("null");
            }else {
                this.right.preorder();
            }
        }
    }
}