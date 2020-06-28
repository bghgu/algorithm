package leetcode.june;

/**
 * Created by ccoli on 2020/06/28.
 */

public class Solution_27_PerfectSquares {

    public static void main(String... args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        if (n < 4) {
            return n;
        }
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}