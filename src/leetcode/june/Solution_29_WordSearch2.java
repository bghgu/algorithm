package leetcode.june;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/06/30.
 */

public class Solution_29_WordSearch2 {

    public static void main(String... args) {
        char[][] arr = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(arr, words));
    }

    private static char[][] arr;
    private static boolean[][] visit;
    private static int n, m;
    private final static int[] DX = {1, -1, 0, 0};
    private final static int[] DY = {0, 0, 1, -1};

    public static List<String> findWords(char[][] board, String[] words) {
        arr = board;
        n = board.length;
        m = board[0].length;

        List<String> result = new LinkedList<>();

        for (String word : words) {
            if (func(word)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean func(final String word) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit = new boolean[n][m];
                if (arr[i][j] == word.charAt(0) && dfs(word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(final String word, final int x, final int y, final int index) {
        if (index == word.length()) return true;
        if (x >= 0 && x < n && y >= 0 && y < m && !visit[x][y] && arr[x][y] == word.charAt(index)) {
            visit[x][y] = true;
            boolean temp = false;
            for (int i = 0; i < 4; i++) {
                int nx = DX[i] + x;
                int ny = DY[i] + y;
                temp = (temp || dfs(word, nx, ny, index + 1));
            }
            visit[x][y] = false;
            return temp;
        }
        return false;
    }
}