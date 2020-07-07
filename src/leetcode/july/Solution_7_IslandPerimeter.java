package leetcode.july;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ccoli on 2020/07/07.
 */

public class Solution_7_IslandPerimeter {

    public static void main(String... args) {
        int[][] arr = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        int[][] arr2 = {{1, 0}};
        System.out.println(islandPerimeter(arr));
        System.out.println(islandPerimeter(arr2));
    }

    private final static int[] DX = {1, -1, 0, 0};
    private final static int[] DY = {0, 0, 1, -1};
    private static int n, m, count;
    private static int[][] arr;
    private static boolean[][] visit;

    public static int islandPerimeter(int[][] grid) {
        count = 0;
        n = grid.length;
        m = grid[0].length;
        arr = grid;
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    func(i, j);
                }
            }
        }

        return count;
    }

    private static void func(final int x, final int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = DX[i] + p.x;
                int ny = DY[i] + p.y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                    }else if (arr[nx][ny] == 0){
                        count++;
                    }
                }else {
                    count++;
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

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}