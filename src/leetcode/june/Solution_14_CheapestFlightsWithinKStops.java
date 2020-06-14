package leetcode.june;

import java.util.*;

/**
 * Created by ccoli on 2020/06/14.
 */

public class Solution_14_CheapestFlightsWithinKStops {

    public static void main(String... args) {
        int[][] arr1 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        //System.out.println(findCheapestPrice(3, arr1, 0, 2, 1));
        int[][] arr2 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        //System.out.println(findCheapestPrice(3, arr2, 0, 2, 0));
        int[][] arr3 = {
                {0, 1, 2},
                {1, 2, 1},
                {2, 0, 10}
        };
        //System.out.println(findCheapestPrice(3, arr3, 1, 2, 1));
        int[][] arr4 = {
                {3, 4, 4},
                {2, 5, 6},
                {4, 7, 10},
                {9, 6, 5},
                {7, 4, 4},
                {6, 2, 10},
                {6, 8, 6},
                {7, 9, 4},
                {1, 5, 4},
                {1, 0, 4},
                {9, 7, 3},
                {7, 0, 5},
                {6, 5, 8},
                {1, 7, 6},
                {4, 0, 9},
                {5, 9, 1},
                {8, 7, 3},
                {1, 2, 6},
                {4, 1, 5},
                {5, 2, 4},
                {1, 9, 1},
                {7, 8, 10},
                {0, 4, 2},
                {7, 2, 8}
        };
        //System.out.println(findCheapestPrice(10, arr4, 6, 0, 7));
        int[][] arr5 = {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };
        //System.out.println(findCheapestPrice(4, arr5, 0, 3, 1));
        int[][] arr6 = {
                {0, 1, 20},
                {1, 2, 20},
                {2, 3, 30},
                {3, 4, 30},
                {4, 5, 30},
                {5, 6, 30},
                {6, 7, 30},
                {7, 8, 30},
                {8, 9, 30},
                {0, 2, 9999},
                {2, 4, 9998},
                {4, 7, 9997}
        };
        System.out.println(findCheapestPrice(10, arr6, 0, 9, 4));
    }

    private static int[][] arr;
    private static int[][] sum;
    private static int n;
    private static int k;
    private static int end;
    private static int result;

    public static int findCheapestPrice(int N, int[][] flights, int src, int dst, int K) {
        n = N;
        k = K;
        end = dst;
        arr = new int[n][n];
        result = Integer.MAX_VALUE;

        List<Pair> list = new ArrayList<>();

        for (int[] flight : flights) {
            int a = flight[0];
            int b = flight[1];
            int c = flight[2];
            arr[a][b] = c;
            list.add(new Pair(a, b, 0));
        }

        for (Pair pair : list) {
            if (pair.x == src) {
                sum = new int[n][n];
                result = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sum[i][j] = Integer.MAX_VALUE;
                    }
                }
                func(pair);
            }
        }

        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static void func(final Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        sum[pair.x][pair.y] = arr[pair.x][pair.y];
        System.out.println(pair.x + " " + pair.y + " " + sum[pair.x][pair.y]);
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.count <= k) {
                if (p.y == end) {
                    System.out.println(p.x + " " + p.y + " " + sum[p.x][p.y]);
                    result = Math.min(result, sum[p.x][p.y]);
                    System.out.println(result);
                }
            }
            for (int i = 0; i < n; i++) {
                if (arr[p.y][i] != 0) {
//                    if (sum[p.y][i] > sum[p.x][p.y] + arr[p.y][i]) {
//                        sum[p.y][i] = sum[p.x][p.y] + arr[p.y][i];
//                        System.out.println(p.y + " " + i + " " + sum[p.x][p.y] + " + " + arr[p.y][i] + " = " + sum[p.y][i]);
//                        queue.offer(new Pair(p.y, i, p.count + 1));
//                    }
                    sum[p.y][i] = sum[p.x][p.y] + arr[p.y][i];
                    System.out.println(p.y + " " + i + " " + sum[p.x][p.y] + " + " + arr[p.y][i] + " = " + sum[p.y][i]);
                    queue.offer(new Pair(p.y, i, p.count + 1));
                }
            }
        }
        System.out.println("######################");
    }

    private static class Pair {
        private int x;
        private int y;
        private int count;

        public Pair(final int x, final int y, final int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}