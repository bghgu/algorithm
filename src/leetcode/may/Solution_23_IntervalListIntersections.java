package leetcode.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/05/23.
 */

public class Solution_23_IntervalListIntersections {

    public static void main(String... args) {
        int[][] a = {
            {0, 2},
            {5, 10},
            {13, 23},
            {24, 25}
        };
        int[][] b = {
            {1, 5},
            {8, 12},
            {15, 24},
            {25, 26}
        };
        System.out.println(Arrays.deepToString(intervalIntersection(a, b)));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new LinkedList<>();

        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);

            if (start <= end) {
                list.add(new int[] {start, end});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            }else {
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

}