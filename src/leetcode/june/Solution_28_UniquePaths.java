package leetcode.june;

/**
 * Created by ccoli on 2020/06/29.
 */

public class Solution_28_UniquePaths {

    public static void main(String... args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

    private static int[][] dp;

    public static int uniquePaths(int m, int n) {
        dp = new int[n][m];
        dp[0][0] = 1;
        return func(n-1, m-1);
    }

    private static int func(final int x, final int y) {
        if (x < 0 || y < 0) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = func(x-1, y) + func(x, y-1);
        return dp[x][y];
    }
}