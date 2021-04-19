package leetcode.medium;

/**
 * Created by ds on 2021/04/16
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 */

public class Solution_1551 {

    public static void main(String... args) {
        System.out.println(minOperations(3));
        System.out.println(minOperations(6));
    }

    public static int minOperations(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (i * 2) + 1;
        }

        int mid = (arr[0] + arr[n - 1]) / 2;

        int sum = 0;
        for (int i : arr) {
            sum += Math.abs(i - mid);
        }

        return sum / 2;
    }

    /**
     * you have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n)
     *
     * in one operation, you can select two indices x and y where 0 <= x, y < n and subtract
     */
}