package leetcode.june;

import java.util.Arrays;

/**
 * Created by ccoli on 2020/06/03.
 */

public class Solution_3_TwoCityScheduling {

    public static void main(String... args) {
        int[][] arr1 = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        System.out.println(twoCitySchedCost(arr1));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[] refund = new int[n * 2];
        int minCost = 0;
        int index = 0;

        for (int[] cost : costs) {
            refund[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }

        Arrays.sort(refund);

        for (int i = 0; i < n; i++) {
            minCost += refund[i];
        }
        return minCost;
    }
}