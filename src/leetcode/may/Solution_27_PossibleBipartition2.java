package leetcode.may;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ccoli on 2020/05/27.
 */

public class Solution_27_PossibleBipartition2 {

    public static void main(String... args) {
        int[][] arr1 = {{1, 2}, {1, 3}, {2, 4}};
        int[][] arr2 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] arr3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] arr4 = {{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10},
            {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9},
            {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}};
        System.out.println(possibleBipartition(4, arr1));
        System.out.println(possibleBipartition(3, arr2));
        System.out.println(possibleBipartition(5, arr3));
        System.out.println(possibleBipartition(10, arr4));
    }

    private static int n;
    private static int[][] arr;
    private static boolean[] visit;

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        n = N;
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;
        int temp = 0;

        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                if (DFS(i)) {
                    temp++;
                }
                count++;
            }
        }

        return count == temp;
    }

    public static boolean DFS(final int x) {
        if(visit[x]) {
            return false;
        }
        visit[x] = true;
        for(int i = 1; i <= n; i++) {
            if(arr[x][i] == 1 && !visit[i]) {
                return DFS(i);
            }
        }
        return true;
    }
}