package leetcode.may;

import java.util.*;

/**
 * Created by ccoli on 2020/05/30.
 */

public class Solution_30_KClosestPointsToOrigin {

    public static void main(String... args) {
        int[][] arr1 = {{1, 3}, {-2, 2}};
        int[][] arr2 = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(kClosest(arr1, 1)));
        System.out.println(Arrays.deepToString(kClosest(arr2, 2)));
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        List<int[]> list = new LinkedList<>();
        for (int[] point : points) {
            int a = point[0];
            int b = point[1];
            queue.offer(new Pair(a, b));
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            list.add(new int[] {p.x, p.y});
            K--;
            if (K == 0) break;
        }

        return list.toArray(new int[list.size()][]);
    }

    private static class Pair implements Comparable<Pair> {

        private int x;
        private int y;
        private int d;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
            this.d = x * x + y * y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.d - o.d;
        }
    }

}