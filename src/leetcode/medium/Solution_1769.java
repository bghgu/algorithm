package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ds on 2021/03/31.
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */

public class Solution_1769 {

    public static void main(String... args) {
        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    public static int[] minOperations(String boxes) {
        int[] answers = new int[boxes.length()];
        String[] strs = boxes.split("");
        int n = strs.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (strs[i].equals("1")) {
                list.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int num : list) {
                answers[i] += Math.abs(i - num);
            }
        }

        return answers;
    }

    /**
     * you have n boxes.
     *
     * you are given a binary string boxes of length n,
     *
     * where boxes[i] is 0 if the ith box is empty,
     * and 1 if it contains one ball
     *
     * in one operation, you can move one ball from a box to an adjacent box
     *
     * box i is adjacent to box j if abs(i - j) == 1
     *
     * note that after doing so,
     * there may be more than one ball in some boxes.
     *
     * return an array answer of size n, where answer[i] is the minimum number of operations needed
     * to move all the balls to the ith box.
     *
     * all the balls
     *
     * each answer[i] is calculated considering the initial state of the boxes.
     */
}