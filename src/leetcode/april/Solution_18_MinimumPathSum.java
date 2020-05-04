package leetcode.april;

/**
 * Created by ccoli on 2020/04/25.
 */

public class Solution_18_MinimumPathSum {

    public static void main(String... args) {
        int[][] arr = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(minPathSum(arr));
        int[][] arr2 = {
            {0}
        };
        System.out.println(minPathSum(arr2));
    }

    private static int n, m;
    private static int[][] arr;
    private static int[][] sum;

    public static int minPathSum(int[][] grid) {
        arr = grid;
        n = grid.length;
        m = grid[0].length;
        sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] = Integer.MAX_VALUE;
            }
        }
        sum[0][0] = arr[0][0];
        return func(n - 1, m - 1);
    }

    private static int func(final int x, final int y) {
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        if (sum[x][y] != Integer.MAX_VALUE) {
            return sum[x][y];
        }
        sum[x][y] = arr[x][y] + Math.min(func(x - 1, y), func(x, y - 1));
        return sum[x][y];
    }
}