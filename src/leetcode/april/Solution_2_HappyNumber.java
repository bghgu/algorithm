package leetcode.april;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ccoli on 2020/04/09.
 */

public class Solution_2_HappyNumber {

    public static void main(String... args) {
        //System.out.println(isHappy(19));
        System.out.println(isHappy(10));
    }

    private static Set<Integer> set;

    public static boolean isHappy(final int n) {
        set = new HashSet<>();
        return func(n);
    }

    public static boolean func(final int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        String[] str = String.valueOf(n).split("");
        int sum = 0;
        for (String s : str) {
            int temp = Integer.parseInt(s);
            sum += (temp * temp);
        }
        return func(sum);
    }
}