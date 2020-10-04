package leetcode.september;

/**
 * Created by ccoli on 2020/09/06.
 */

public class Solution_6_ImageOverlap {

    public static void main(String... args) {
        int[][] a = {
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}};
        int[][] b = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}};

        int[][] c = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 1}};
        int[][] d = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1}};

        System.out.println(largestOverlap(a, b));
        System.out.println(largestOverlap(c, d));
    }

    private static int n;
    private static int[][] arr1;
    private static int[][] arr2;

    public static int largestOverlap(int[][] A, int[][] B) {
        int result = 0;

        arr1 = A;
        arr2 = B;

        n = B.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        result = Math.max(result, func(i, j, a, b));
                    }
                }

            }
        }

        return result;
    }

    private static int func(final int x, final int y, final int a, final int b) {
        int count = 0;
        int i = x, j = y;
        int k = a, l = b;

        while (i != n && k != n) {
            if (arr1[i][j] == 1 && arr1[i][j] == arr2[k][l]) {
                count++;
            }

            j++;
            l++;

            if (j == n || l == n) {
                j = y;
                l = b;
                i++;
                k++;
            }
        }

        return count;
    }
}