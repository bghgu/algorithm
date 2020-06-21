package leetcode.june;

/**
 * Created by ccoli on 2020/06/21.
 */

public class Solution_21_DungeonGame {

    public static void main(String... args) {
        int[][] arr = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(calculateMinimumHP(arr));
    }

    private static int[][] arr;
    private static int[][] dp;
    private static int n, m;

    public static int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        arr = dungeon;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = arr[0][0];
        func(n - 1, m - 1);
        int result = dp[n-1][m-1];
        if (result < 0) {
            return (result * -1) + 1;
        }else {
            return result;
        }
    }

    private static int func(final int x, final int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return Integer.MIN_VALUE;
        }
        if (dp[x][y] != Integer.MIN_VALUE) {
            return dp[x][y];
        }
        if (x == n-1 && y == m-1) {
            dp[x][y] = Math.min(func(x - 1, y), func(x, y - 1)) + arr[x][y];
        }else {
            dp[x][y] = Math.max(func(x - 1, y), func(x, y - 1)) + arr[x][y];
        }
        return dp[x][y];
    }
}