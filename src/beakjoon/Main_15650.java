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

public class Main_15650 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static boolean[] visit;
    private static int n, m;

    public static void main(String... args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];

        func(0, 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void func(final int x, final int count) {
        if (count == m) {
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    //A
                    sb.append(i + 1).append(" ");
                }else {
                    //B
                }
            }
            sb.append("\n");
        }
        for (int i = x; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                func(i + 1, count + 1);
                visit[i] = false;
            }else return;
        }
    }

    /**
     * n과 m 2
     * 1부터 n 까지 중복 없이 m개를 고른 수열
     */
}