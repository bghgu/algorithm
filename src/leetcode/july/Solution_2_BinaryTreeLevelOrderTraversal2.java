package leetcode.july;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/07/02.
 */

public class Solution_2_BinaryTreeLevelOrderTraversal2 {

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(treeNode));
    }

    //즉, 왼쪽에서 오른쪽으로, 리프에서 루트까지 레벨별로 레벨을 조정하십시오

    private static List<List<Integer>> result;
    private static int maxLevel;

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new LinkedList<>();
        if (root == null) return result;
        maxLevel = 0;
        func(root, 0);
        for (int i = 0; i <= maxLevel; i++) {
            result.add(new LinkedList<>());
        }
        func(root, 0);
        Collections.reverse(result);
        return result;
    }

    private static void func(final TreeNode now, final int level) {
        if (now.left != null) func(now.left, level + 1);
        if (now.right != null) func(now.right, level + 1);
        maxLevel = Math.max(level, maxLevel);
        if (result.size() != 0) {
            result.get(level).add(now.val);
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