package leetcode.medium;

/**
 * Created by ds on 2021/04/11.
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 */

public class Solution_807 {

    public static void main(String... args) {
        int[][] arr = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(arr));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] vertical = new int[n];
        int[] horizontal = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vertical[i] = Math.max(vertical[i], grid[i][j]);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int[] ints : grid) {
                horizontal[j] = Math.max(horizontal[j], ints[j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int newHeight = Math.min(horizontal[j], vertical[i]);
                sum += Math.abs(newHeight - grid[i][j]);
                grid[i][j] = newHeight;
            }
        }

        return sum;
    }

    /**
     * in a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
     *
     * we are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for
     * different building).
     *
     * height 0 is considered to be a building as well.
     *
     * at the end, the skyline when viewed from all four directions of the grid, i.e. top, bottom, left, and right,
     * must be the same as the skyline of the original grid.
     *
     * a city`s skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance.
     *
     *
     */
}