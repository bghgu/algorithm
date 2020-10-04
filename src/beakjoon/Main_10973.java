package beakjoon;

import java.io.*;

/**
 * Created by ccoli on 2020/09/06.
 */

public class Main_10973 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;

    private static boolean[] visit;
    private static String matcher;
    private static String last = "-1 ";
    private static String result = "";
    private static int[] order;

    public static void main(String... args) throws IOException {
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        order = new int[n];

        matcher = String.join("", br.readLine().split(""));

        func(0, 0);



        bw.write(result + "");
        bw.close();
        br.close();
    }

    private static void func(final int x, final int c) {
        if (c == n) {
            StringBuilder now = new StringBuilder();
            for (int i = 0; i < n; i++) {
                now.append(order[i] + 1);
                if (i < n - 1) {
                    now.append(" ");
                }
            }

            if (matcher.equals(now.toString())) {
                result = last;
            } else {
                last = now.toString();
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                order[x] = i;
                func(x + 1, c + 1);
                visit[i] = false;
            }
        }
    }
}