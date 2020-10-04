package beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/09/06.
 */

public class Main_2961 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n, result = Integer.MAX_VALUE;
    private static boolean[] visit;
    private static int[][] arr;

    public static void main(String... args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            func(0, 0, i);
        }

        bw.write(result + "");
        bw.close();
        br.close();
    }

    private static void func(final int x, final int count, final int max) {
        if (count == max) {
            int sum = 0;
            int multi = 1;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    sum += arr[i][1];
                    multi *= arr[i][0];
                }
            }
            result = Math.min(result, Math.abs(sum - multi));
        }else {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    func(x + 1, count + 1, max);
                    visit[i] = false;
                }else {
                    break;
                }
            }
        }
    }
}