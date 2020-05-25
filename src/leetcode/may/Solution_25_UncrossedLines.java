package leetcode.may;

/**
 * Created by ccoli on 2020/05/25.
 */

public class Solution_25_UncrossedLines {

    public static void main(String... args) {
        int[] a1 = {2, 5, 1, 2, 5};
        int[] b1 = {10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(a1, b1));
    }

    private static int[][] dp;
    private static int[] a;
    private static int[] b;

    public static int maxUncrossedLines(int[] A, int[] B) {
        dp = new int[A.length][B.length];
        a = A;
        b = B;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i][j] = -1;
            }
        }

        return lcs(0, 0);
    }

    private static int lcs(int i, int j) {
        if (i == a.length || j == b.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a[i] == b[j]) {
            return dp[i][j] = 1 + lcs(i + 1, j + 1);
        } else {
            return dp[i][j] = Math.max(lcs(i + 1, j), lcs(i, j + 1));
        }
    }

}