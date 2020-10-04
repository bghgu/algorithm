package leetcode.august;

import java.util.*;

/**
 * Created by ccoli on 2020/08/31.
 * https://leetcode.com/explore/featured/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/
 */

public class Solution_31_LargestComponentSizeByCommonFactor {

    public static void main(String... args) {
        int[] arr1 = {4, 6, 15, 35};
        int[] arr2 = {20, 50, 9, 63};
        int[] arr3 = {2, 3, 6, 7, 4, 12, 21, 39};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr5 = {66, 100, 37, 40, 41, 76, 49, 62};
        int[] arr6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int[] arr7 = {32, 98, 9, 43, 66, 49, 83, 94, 95};

//        System.out.println(largestComponentSize(arr1));
//        System.out.println(largestComponentSize(arr2));
//        System.out.println(largestComponentSize(arr3));
//        System.out.println(largestComponentSize(arr4));
//        System.out.println(largestComponentSize(arr5));
//        System.out.println(largestComponentSize(arr6));
        System.out.println(largestComponentSize(arr7));
    }

    private static int[][] arr;
    private static boolean[] visit;
    private static int max = 0, count = 0;
    private static Map<Integer, List<Integer>> map;
    private static int n;
    private static int[] B;

    public static int largestComponentSize(int[] A) {
        n = A.length;
        max = 0;
        count = 0;
        B = A;

        map = new HashMap<>();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] == 1 || A[j] == 1) continue;
                int temp = gcd(A[i], A[j]);
                if (temp > 1) {
                    if (map.containsKey(i)) {
                        map.get(i).add(j);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        map.put(i, list);
                    }
                    if (map.containsKey(j)) {
                        map.get(j).add(i);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        map.put(j, list);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i) != null) {
                visit = new boolean[n];
                visit[i] = true;
                visit[map.get(i).get(0)] = true;
                count = 2;
                dfs(map.get(i).get(0));
                max = Math.max(max, count);
            }
        }

        return max;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(final int y) {
        if (map.get(y) != null) {
            for (int i : map.get(y)) {
                if (!visit[i]) {
                    visit[i] = true;
                    count++;
                    dfs(i);
                }
            }
        }
    }

    private static int gcd(final int a, final int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}