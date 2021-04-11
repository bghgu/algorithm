package leetcode.medium;

/**
 * Created by ds on 2021/04/11.
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */

public class Solution_1379 {

    public static void main(String... args) {

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return search(cloned, target);
    }

    private static TreeNode search(final TreeNode now, final TreeNode target) {
        if (now.val == target.val) {
            return now;
        } else {
            TreeNode result = null;
            if (now.left != null) {
                result = search(now.left, target);
            }
            if (now.right != null && result == null) {
                result = search(now.right, target);
            }
            return result;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Given two binary trees original and clone and given a reference to a node target in the original tree.
     *
     * the cloned tree is a copy of the original tree
     *
     * return a reference to the same node in the cloned tree.
     *
     * Note that you are not allowed to change any of the two trees or the target node and the answer
     * must be a reference to a node in the cloned tree
     *
     * solve the problem if repeated values on the tree are allowed.
     */
}