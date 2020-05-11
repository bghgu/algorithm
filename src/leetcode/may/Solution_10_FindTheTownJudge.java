package leetcode.may;

/**
 * Created by ccoli on 2020/05/11.
 */

public class Solution_10_FindTheTownJudge {

    public static void main(String... args) {
        int[][] arr1 = {{1, 2}};
        int[][] arr2 = {{1, 3}, {2, 3}};
        int[][] arr3 = {{1, 3}, {2, 3}, {3, 1}};
        int[][] arr4 = {{1, 2}, {2, 3}};
        int[][] arr5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(findJudge(2, arr1));
        System.out.println(findJudge(3, arr2));
        System.out.println(findJudge(3, arr3));
        System.out.println(findJudge(3, arr4));
        System.out.println(findJudge(4, arr5));
    }

    public static int findJudge(int N, int[][] trust) {
        boolean[] visit = new boolean[N + 1];
        for (int[] ints : trust) {
            visit[ints[0]] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) return i;
        }
        return -1;
    }
}