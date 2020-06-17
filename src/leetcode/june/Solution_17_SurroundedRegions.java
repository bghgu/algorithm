package leetcode.june;

import java.util.*;

/**
 * Created by ccoli on 2020/06/17.
 */

public class Solution_17_SurroundedRegions {

    public static void main(String... args) {
        char[][] arr = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static int n, m;
    private static char[][] arr;
    private static boolean[][] visit;

    public static void solve(char[][] board) {
        try {
            n = board.length;
            m = board[0].length;
        }catch (Exception e) {
            return;
        }

        arr = board;

        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'O' && !visit[i][j]) {
                    func(i, j);
                }
            }
        }
    }

    private static void func(final int x, final int y) {
        Queue<Pair> queue = new LinkedList<>();
        List<Pair> list = new ArrayList<>();
        queue.offer(new Pair(x, y));
        list.add(new Pair(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = DX[i] + p.x;
                int ny = DY[i] + p.y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 'O' && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        list.add(new Pair(nx, ny));
                        queue.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        boolean flag = true;

        for (Pair p : list) {
            for (int i = 0; i < 4; i++) {
                int nx = DX[i] + p.x;
                int ny = DY[i] + p.y;
                if (0 > nx || nx >= n || 0 > ny || ny >= m) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) {
            for (Pair p : list) {
                arr[p.x][p.y] = 'X';
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