package leetcode.april;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ccoli on 2020/04/25.
 */

public class Solution_17_NumberOfIslands {

    public static void main(String... args) {
        char[][] arr1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        };
        char[][] arr2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(arr1));
        System.out.println(numIslands(arr2));
    }

    final static int[] dx = {1, -1, 0, 0};
    final static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visit;
    private static char[][] arr;
    private static int n, m;

    public static int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        arr = grid;
        visit = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    visit[i][j] = true;
                    count++;
                    bfs(i, j);
                }
            }
        }

        return count;
    }

    private static void bfs(final int x, final int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == '1' && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    private static class Pair {

        private int x;
        private int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}