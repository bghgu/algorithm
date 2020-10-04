package beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/09/03.
 */

public class Main_2455 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String... args) throws IOException {

        int now = 0;
        int result = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            now -= out;
            now += in;

            result = Math.max(result, now);
        }

        bw.write(result + "");
        bw.close();
        br.close();
    }
}