package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2021/04/20
 * https://leetcode.com/problems/partition-labels/
 */

public class Solution_763 {

    public static void main(String... args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();

        String[] s1 = S.split("");
        String[] s2 = S.split("");
        Arrays.sort(s2);

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            System.out.println(s1[i] + " " + s2[i]);
        }

        return list;
    }
}