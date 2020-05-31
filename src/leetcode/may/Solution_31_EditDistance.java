package leetcode.may;

/**
 * Created by ccoli on 2020/05/31.
 */

public class Solution_31_EditDistance {

    public static void main(String... args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("microsoft", "ncsoft"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        String[] str1 = word1.split("");
        String[] str2 = word2.split("");
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1].equals(str2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }

        return dp[len1][len2];
    }

    private static void print(final int[][] dp, final int len1, final int len2) {
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}