package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ds on 2021/04/16.
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */

public class Solution_1329 {

    public static void main(String... args) {
        int[][] arr1 = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] arr2 = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        System.out.println(Arrays.deepToString(diagonalSort(arr1)));
        System.out.println(Arrays.deepToString(diagonalSort(arr2)));
    }

    private static int n;
    private static int m;
    private static boolean[][] visit;

    public static int[][] diagonalSort(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    func(mat, i, j);
                }
            }
        }

        return mat;
    }

    private static void func(final int[][] arr, final int x, final int y) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int x1 = x;
        int y1 = y;
        while (x1 != n && y1 != m) {
            visit[x1][y1] = true;
            queue.add(arr[x1++][y1++]);
        }

        x1 = x;
        y1 = y;
        while (x1 != n && y1 != m && !queue.isEmpty()) {
            arr[x1++][y1++] = queue.poll();
        }
    }

    /**
     * a matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or
     * leftmost column and going in the bottom-right direction until reaching the matrix`s end.
     *
     * for example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0],
     * mat[3][1], and mat[4][2].
     *
     * given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
     */
}