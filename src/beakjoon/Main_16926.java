package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/04/04.
 */

public class Main_16926 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int n, m, r;
    private static int[][] arr;

    public static void main(String... args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (r-- > 0) {
            int sx = 0;
            int sy = 0;
            int ex = n;
            int ey = m;
            for (int i = 0; i < Math.min(n, m) / 2; i++) {
                func(sx + i, sy + i, ex - i, ey - i);
            }
        }

        print(arr);

        bw.close();
        br.close();
    }

    private static void print(final int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void func(final int sx, final int sy, final int ex, final int ey) {
        int temp = arr[sx][sy];
        //윗줄
        for (int j = sy; j < ey - 1; j++) {
            arr[sx][j] = arr[sx][j + 1];
        }
        //오른쪽줄
        for (int i = sx; i < ex - 1; i++) {
            arr[i][ey - 1] = arr[i + 1][ey - 1];
        }
        //아랫줄
        for (int j = ey - 1; j > sy; j--) {
            arr[ex - 1][j] = arr[ex - 1][j - 1];
        }
        //왼쪽줄
        for (int i = ex - 1; i > sx; i--) {
            arr[i][sy] = arr[i - 1][sy];
        }
        arr[sx + 1][sy] = temp;
    }
}