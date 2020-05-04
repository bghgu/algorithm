package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/04/03.
 */

public class Main_15649 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static boolean[] visit;
    private static int[] order;
    private static int n, m;

    public static void main(String... args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        order = new int[n + 1];

        func(0, 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void func(final int x, final int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(order[i]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                order[x] = i + 1;
                func(x + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    /**
     * n과 m 1
     * 1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열
     * 1 2
     * 1 3
     * 1 4
     * 2 1
     * 2 3
     * 2 4
     */
}