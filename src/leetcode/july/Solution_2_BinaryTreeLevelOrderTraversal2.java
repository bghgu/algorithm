package leetcode.july;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/07/02.
 */

public class Solution_2_BinaryTreeLevelOrderTraversal2 {

    public static void main(String... args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        TreeNode now = root;

        return result;
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