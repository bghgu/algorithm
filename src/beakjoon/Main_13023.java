package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/08/17.
 */

public class Main_13023 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int n, m;

    private static boolean flag;

    private static boolean[] visit;

    private static List<List<Integer>> list = new ArrayList<>();

    public static void main(String... args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        flag = false;

        for (int i = 0; i < n; i++) {
            if (!list.get(i).isEmpty() && !flag) {
                visit = new boolean[n];
                visit[i] = true;
                func(i, 0);
            }
        }

        if (flag) {
            bw.write("1");
        }else {
            bw.write("0");
        }

        bw.close();
        br.close();
    }

    private static void func(final int x, final int count) {
        if (count == 4) {
            flag = true;
            return;
        }

        for (int i : list.get(x)) {
            if (!visit[i]) {
                visit[i] = true;
                func(i, count + 1);
                visit[i] = false;
            }
        }
    }
}