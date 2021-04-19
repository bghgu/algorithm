package leetcode.medium;

/**
 * Created by ds on 2021/04/12.
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */

public class Solution_1315 {

    public static void main(String... args) {

    }

    private static int sum = 0;

    public static int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        search(root);
        return sum;
    }

    public static void search(final TreeNode now) {
        if (now.val % 2 == 0) {
            evenSearch(now, 0);
        }
        if (now.left != null) {
            search(now.left);
        }
        if (now.right != null) {
            search(now.right);
        }
    }

    public static void evenSearch(final TreeNode node, final int depth) {
        if (depth == 2) {
            sum += node.val;
        } else {
            if (node.left != null) {
                evenSearch(node.left, depth + 1);
            }
            if (node.right != null) {
                evenSearch(node.right, depth + 1);
            }
        }
    }

    public class TreeNode {
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