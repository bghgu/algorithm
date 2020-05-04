package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by ccoli on 2020/04/03.
 */

public class Main_2108 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String... args) throws IOException {
        final int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        double sum = 0;
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            sum += temp;

            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        PriorityQueue<Pair> queue = map.keySet().stream().mapToInt(key -> key)
            .mapToObj(key -> new Pair(key, map.get(key)))
            .collect(Collectors.toCollection(PriorityQueue::new));

        Arrays.sort(arr);

        //산술 평균
        sb.append(Math.round(sum / n)).append("\n");
        //중앙값
        sb.append(arr[arr.length / 2]).append("\n");
        //최빈값
        Pair p = queue.poll();
        if (!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (p.count == temp.count) {
                p = temp;
            }
        }
        sb.append(p.num).append("\n");

        //범위
        sb.append(arr[arr.length - 1] - arr[0]).append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static class Pair implements Comparable<Pair> {

        private int num;
        private int count;

        public Pair(final int num, final int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.count < this.count) {
                return -1;
            } else if (o.count > this.count) {
                return 1;
            } else {
                return this.num - o.num;
            }
        }
    }
}