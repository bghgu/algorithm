package leetcode.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ccoli on 2020/05/05.
 */

public class Solution_2_JewelsAndStones {

    public static void main(String... args) {
        String j1 = "aA";
        String s1 = "aAAbbbb";
        String j2 = "z";
        String s2 = "ZZ";
        System.out.println(numJewelsInStones(j1, s1));
        System.out.println(numJewelsInStones(j2, s2));
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<String> set = new HashSet<>(Arrays.asList(J.split("")));
        for (String s : S.split("")) {
            if (set.contains(s)) count++;
        }
        return count;
    }
}