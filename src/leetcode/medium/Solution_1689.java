package leetcode.medium;

/**
 * Created by ds on 2021/04/11.
 * https://leetcode.com/problems/find-center-of-star-graph/
 */

public class Solution_1689 {

    public static void main(String... args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        int max = 0;
        for (String str : n.split("")) {
            max = Math.max(Integer.parseInt(str), max);
        }
        return max;
    }

    /**
     * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
     *
     * for example, 101 and 1100 are deci-binary, while 112 and 3002 are not
     *
     * given a staring n that represents a positive decimal integer, return the minimum number of positive deci-binary
     * numbers needed so that they sum up to n.
     */
}