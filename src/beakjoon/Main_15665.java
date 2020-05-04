package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/04/03.
 */

public class Main_15665 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m;
    private static int[] arr;
    private static int[] order;
    private static Set<String> set;

    public static void main(String... args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        order = new int[m];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        func(0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void func(final int count) {
        if (count == m) {
            final StringBuilder temp = new StringBuilder();
            for (int i = 0; i < m; i++) {
                temp.append(order[i]).append(" ");
            }
            if (!set.contains(temp.toString())) {
                sb.append(temp.toString()).append("\n");
            }
            set.add(temp.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            order[count] = arr[i];
            func(count + 1);
        }
    }
}