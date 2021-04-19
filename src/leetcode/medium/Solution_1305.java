package leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2021/04/20
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */

public class Solution_1305 {

    public static void main(String... args) {

    }

    private static List<Integer> result;

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        result = new LinkedList<>();

        if (root1 != null) {
            search(root1);
        }
        if (root2 != null) {
            search(root2);
        }

        Collections.sort(result);

        return result;
    }

    private static void search(TreeNode now) {
        result.add(now.val);
        if (now.left != null) {
            search(now.left);
        }
        if (now.right != null) {
            search(now.right);
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

    /**
     * given two binary search trees root1 and root2.
     *
     * return a list containing all the integers from both trees sorted in ascending order
     */
}