package beakjoon;

import java.io.*;

/**
 * Created by ccoli on 2020/09/06.
 */

public class Main_12852 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] dp = new int[1000001];
    private static int[] order = new int[1000001];
    private static boolean flag = false;

    public static void main(String... args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        dp[2] = 1;

        int count = func(n, 0);

        System.out.println("######");

        for (int i = 1; i<= n; i++) {
            System.out.println(i + " " + dp[i]);
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }

    private static int func(final int x, final int count) {
        if (dp[x] != 0) {
            return dp[x];
        }
        if (x <= 1) {
            System.out.println(count + " " + x);
            order[x] = 1;
            return 0;
        } else {
            dp[x] = Integer.MAX_VALUE;
        }
        if (x % 3 == 0) {
            int temp = func(x / 3, count + 1) + 1;
            if (temp < dp[x]) {
                dp[x] = temp;
                System.out.println(count + " " + x);
                order[count] = x;
            }
        }
        if (x % 2 == 0) {
            int temp = func(x / 2, count + 1) + 1;
            if (temp < dp[x]) {
                dp[x] = temp;
                System.out.println(count + " " + x);
                order[count] = x;
            }
        }
        int temp = func(x - 1, count + 1) + 1;
        if (temp < dp[x]) {
            dp[x] = temp;
            System.out.println(count + " " + x);
            order[count] = x;
        }
        return dp[x];
    }
}