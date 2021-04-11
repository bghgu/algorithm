package beakjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ccoli on 2020/12/26.
 */

public class Main_1927 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String... args) throws IOException {

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(12345678));
        queue.offer(new Node(1));
        queue.offer(new Node(2));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll().x);
        }

        List<Node> nodeList = new LinkedList<>();
        
        bw.write("");
        bw.close();
        br.close();
    }

    private static class Node implements Comparable<Node> {
        private int x;
        private int y;
        private int age;

        public Node(final int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x < o.x) {
                return -1;
            }else if (this.x > o.x) {
                return 1;
            }else {
                if (this.y < o.y) {
                    return 1;
                }else if (this.y > o.y) {
                    return -1;
                }else {
                    return this.age - o.age;
                }
            }
        }
    }
}