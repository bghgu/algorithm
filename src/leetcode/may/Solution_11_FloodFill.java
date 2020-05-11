package leetcode.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ccoli on 2020/05/11.
 */

public class Solution_11_FloodFill {

    public static void main(String... args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] arr2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0;
        int sc2 = 0;
        int newColor2 = 2;
        System.out.println(Arrays.deepToString(floodFill(arr, sr, sc, newColor)));
        System.out.println(Arrays.deepToString(floodFill(arr2, sr2, sc2, newColor2)));
    }

    private final static int[] DX = {1, -1, 0, 0};
    private final static int[] DY = {0, 0, 1, -1};

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final int n = image.length;
        final int m = image[0].length;
        final int now = image[sr][sc];
        final boolean[][] visit = new boolean[n][m];
        final Queue<Pair> queue = new LinkedList<>();

        visit[sr][sc] = true;
        image[sr][sc] = newColor;
        queue.offer(new Pair(sr, sc));
        while (!queue.isEmpty()) {
            final Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                final int nx = DX[i] + p.x;
                final int ny = DY[i] + p.y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny] && image[nx][ny] == now) {
                    visit[nx][ny] = true;
                    image[nx][ny] = newColor;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
        return image;
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