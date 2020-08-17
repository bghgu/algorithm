package beakjoon;

import java.io.*;
import java.util.*;

/**
 * Created by ccoli on 2020/07/30.
 */

public class Main_2493 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String... args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                Pair p = stack.peek();
                if (p.data >= now) {
                    sb.append(p.index).append(" ");
                    stack.add(new Pair(now, i + 1));
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new Pair(now, i + 1));
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static class Pair {
        private int index;
        private int data;

        public Pair(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }
}