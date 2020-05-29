package leetcode.may;

import java.util.Arrays;

/**
 * Created by ccoli on 2020/05/29.
 */

public class Solution_28_CountingBits {

    public static void main(String... args) {
        System.out.println(Arrays.toString(countBits(0)));
        System.out.println(Arrays.toString(countBits(1)));
        //System.out.println(Arrays.toString(countBits(2)));
        //System.out.println(Arrays.toString(countBits(3)));
        //System.out.println(Arrays.toString(countBits(4)));
        //System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits(11)));
    }

    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            int x = (int) (Math.log(i) / Math.log(2));
            int y = (int) Math.pow(2, x);

            int remain = i - y;
            dp[i] = 1 + dp[remain];
        }

        return dp;
    }
}