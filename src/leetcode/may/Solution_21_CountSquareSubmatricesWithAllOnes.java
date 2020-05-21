package leetcode.may;

/**
 * Created by ccoli on 2020/05/21.
 */

public class Solution_21_CountSquareSubmatricesWithAllOnes {

    public static void main(String... args) {
        int[][] arr1 = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        int[][] arr2 = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };
        System.out.println(countSquares(arr1));
        System.out.println(countSquares(arr2));
    }

    private static int[][] arr;
    private static int n;
    private static int m;

    public static int countSquares(int[][] matrix) {
        int size = 1;
        int sum = 0;
        n = matrix.length;
        m = matrix[0].length;
        arr = matrix;
        int end = Math.min(n, m);
        while (size <= end) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1 && func(i, j, size)) {
                        sum++;
                    }
                }
            }
            size++;
        }
        return sum;
    }

    private static boolean func(final int x, final int y, final int size) {
        if (x + size <= n && y + size <= m) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (arr[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}