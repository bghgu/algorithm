package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/08/30.
 */

public class Main_3109 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int[] DX = {-1, 0, 1};
    private static final int[] DY = {1, 1, 1};

    private static char[][] arr;
    private static int n, m, count = 0;
    private static boolean flag;

    public static void main(String... args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            if (m >= 0) {
                System.arraycopy(temp, 0, arr[i], 0, m);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i][1] == '.') {
                flag = false;
                arr[i][1] = '@';
                func(i, 1);
                if (flag) {
                    count++;
                }
            }
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }

    private static void func(final int x, final int y) {
        if (y == m - 1) {
            flag = true;
        } else {
            for (int i = 0; i < 3; i++) {
                int nx = DX[i] + x;
                int ny = DY[i] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == '.' && !flag) {
                        arr[nx][ny] = '@';
                        func(nx, ny);
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 유명한 제빵사 김원웅은 빵집을 운영하고 있다.
     * 원웅이는 근처 빵집의 가스관에 몰래 파이프를 설치해 훔쳐서 사용하기로 했다.
     *
     * 빵집이 있는 곳은 R * C 격자로 표현할 수 있다.
     * 첫째 열은 근처 빵집의 가스관이고, 마지막 열은 원웅이의 빵집이다.
     *
     * 원웅이는 가스관과 빵집을 연결하는 파이프를 설치하려고 한다.
     * 빵집과 가스관 사이에는 건물이 있을 수도 있다.
     * 건물이 있는 경우에는 파이프를 놓을 수 없다.
     *
     * 가스관과 빵집을 연결하는 모든 파이프라인은 첫째 열에서 시작해야 하고,
     * 마지막 열에서 끝나야 한다.
     * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있고,
     * 각 칸의 중심끼리 연결하는 것이다.
     *
     * 원웅이는 가스를 되도록 많이 훔치려고 한다. 따라서, 가스관과 빵집을 연결하는 파이프라인을 여러 개 설치할 것이다.
     * 이 경로는 겹칠 수 없고, 서로 접할 수도 없다.
     * 즉, 각 칸을 지나는 파이프는 하나이어야 한다.
     *
     * 원웅이 빵집의 모습이 주어졌을 때, 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구해라
     *
     * .는 빈칸, X는 건물
     * 처음과 마지막 열은 항상 비어있다.
     */
}