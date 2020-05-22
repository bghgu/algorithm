package leetcode.may;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ccoli on 2020/05/22.
 */

public class Solution_22_SortCharactersByFrequency {

    public static void main(String... args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : s.split("")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }else {
                map.put(str, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        map.keySet().stream().map(str -> new Pair(str, map.get(str))).forEach(queue::offer);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.str);
            }
        }

        return sb.toString();
    }

    private static class Pair implements Comparable<Pair>{
        private String str;
        private int count;

        public Pair(final String str, final int count) {
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.count < o.count) return 1;
            else if (this.count > o.count) return -1;
            else {
                return str.compareTo(o.str);
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                "str='" + str + '\'' +
                ", count=" + count +
                '}';
        }
    }
}