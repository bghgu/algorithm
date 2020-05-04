package leetcode.april;

/**
 * Created by ccoli on 2020/04/26.
 */

public class Solution_25_JumpGame {

    public static void main(String... args) {
        int[] arr1 = {2, 3, 1, 1, 4};
        int[] arr2 = {3, 2, 1, 0, 4};
        int[] arr3 = {0};
        System.out.println(canJump(arr1));
        System.out.println(canJump(arr2));
        System.out.println(canJump(arr3));
    }

    private static int[] arr;
    private static boolean[] visit;
    private static int n;

    public static boolean canJump(int[] nums) {
        n = nums.length;
        visit = new boolean[n];
        arr = nums;
        if (n == 1) return true;
        for (int i = 1; i <= arr[0]; i++) {
            if (dfs(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(final int x) {
        if (x == n - 1) {
            return true;
        }
        if (visit[x]) {
            return false;
        }
        visit[x] = true;
        for (int i = 1; i <= arr[x]; i++) {
            if (x + i < n && dfs(x + i)) {
                return true;
            }
        }
        return false;
    }
}