package leetcode.september;

/**
 * Created by ccoli on 2020/09/09.
 */

public class Solution_8_SumOfRootToLeafBinaryNumbers {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(treeNode));
    }

    private static int result = 0;

    public static int sumRootToLeaf(TreeNode root) {
        result = 0;
        func(root, String.valueOf(root.val));

        return result;
    }

    private static void func(final TreeNode node, final String str) {
        if (node.left == null && node.right == null) {
            result += Integer.parseInt(str, 2);
        } else {
            if (node.left != null) {
                func(node.left, str + node.left.val);
            }
            if (node.right != null) {
                func(node.right, str + node.right.val);
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