package leetcode.june;

/**
 * Created by ccoli on 2020/06/24.
 */

public class Solution_24_UniqueBinarySearchTrees {

    public static void main(String... args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int root = 0; root < i; root++) {
                int left = root;
                int right = i - 1 - left;
                dp[i] += (dp[left] * dp[right]);
            }
        }
        return dp[n];
    }
}