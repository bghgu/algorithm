package leetcode.april;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ccoli on 2020/04/19.
 */

public class Solution_12_LastStoneWeight {

    public static void main(String... args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        int[] arr2 = {1, 3};
        int[] arr3 = {2, 2};
        System.out.println(lastStoneWeight(arr));
        System.out.println(lastStoneWeight(arr2));
        System.out.println(lastStoneWeight(arr3));
    }

    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new LinkedList<>();
        for (int stone : stones) {
            list.add(stone);
        }

        PriorityQueue<Pair> queue;
        List<Integer> temp;

        while (list.size() > 1) {
            queue = new PriorityQueue<>();
            temp = new LinkedList<>();

            for (int i = 0; i < list.size(); i++) {
                queue.add(new Pair(list.get(i), i));
            }
            Pair p1 = queue.poll();
            Pair p2 = queue.poll();

            if (p1.num != p2.num) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == p2.index) continue;
                    else if (i == p1.index) {
                        temp.add(p1.num - p2.num);
                    }else {
                        temp.add(list.get(i));
                    }
                }
            }else {
                for (int i = 0; i < list.size(); i++) {
                    if (i == p1.index || i == p2.index) continue;
                    temp.add(list.get(i));
                }
            }

            list = temp;

        }

        return list.size() != 0 ? list.get(0) : 0;
    }

    private static class Pair implements Comparable<Pair> {
        private int num;
        private int index;

        public Pair(final int num, final int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.num > this.num) return 1;
            else if (o.num < this.num) return -1;
            else {
                return this.index - o.index;
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                "num=" + num +
                ", index=" + index +
                '}';
        }
    }
}