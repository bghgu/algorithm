package leetcode.june;

import java.util.*;

/**
 * Created by ccoli on 2020/06/07.
 */

public class Solution_7_CoinChange2 {

    public static void main(String... args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change(3, new int[]{2}));
        System.out.println(change(10, new int[]{10}));
    }

    private static int max;
    private static int n;
    private static int[] arr;
    private static int[] order;
    private static Set<String> set;

    public static int change(int amount, int[] coins) {
        max = amount;
        arr = coins;
        n = coins.length;
        set = new HashSet<>();
        for (int i = 0; i <= amount; i++) {
            order = new int[amount];
            func(i, 0);
        }
        return set.size();
    }

    public static int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    private static void func(final int count, final int nowCount) {
        if (count == nowCount) {
            int sum = 0;
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                sum += order[i];
                list.add(order[i]);
            }
            if (sum == max) {
                Collections.sort(list);
                StringBuilder sb = new StringBuilder();
                for (int i : list) {
                    sb.append(i);
                }
                set.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            order[nowCount] = arr[i];
            func(count, nowCount + 1);
        }
    }
}