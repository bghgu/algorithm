package beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/08/31.
 */

public class Main_17779 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    private static int[][] arr;
    private static int[][] area;
    private static int result;
    private static int[] sum;

    public static void main(String... args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        area = new int[n + 1][n + 1];
        result = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if ((1 <= x) && (x < x + d1 + d2) && (x + d1 + d2 <= n) && (1 <= y - d1) && (y < y + d2) && (y + d2 <= n)) {
                            func(x, y, d1, d2);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        bw.write(result + "");
        bw.close();
        br.close();
    }

    private static void func(final int x, final int y, final int d1, final int d2) {
        area = new int[n + 1][n + 1];
        sum = new int[6];
        check5(x, y, d1, d2);
    }

    private static void check5(final int x, final int y, final int d1, final int d2) {
        for (int i = 0; i <= d1; i++) {
            area[x + i][y - i] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            area[x + i][y + i] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            area[x + d1 + i][y - d1 + i] = 5;
        }

        for (int i = 0; i <= d1; i++) {
            area[x + d2 + i][y + d2 - i] = 5;
        }

        check1(x, y, d1, d2);
        check2(x, y, d1, d2);
        check3(x, y, d1, d2);
        check4(x, y, d1, d2);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 5;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[area[i][j]] += arr[i][j];
            }
        }

        Arrays.sort(sum);

        result = Math.min(result, sum[5] - sum[1]);
    }

    private static void check1(final int x, final int y, final int d1, final int d2) {
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 1;
                } else {
                    break;
                }
            }
        }
    }

    private static void check2(final int x, final int y, final int d1, final int d2) {
        for (int i = 1; i <= x + d2; i++) {
            for (int j = n; j > x; j--) {
                if (area[i][j] == 0) {
                    area[i][j] = 2;
                } else {
                    break;
                }
            }
        }
    }

    private static void check3(final int x, final int y, final int d1, final int d2) {
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 3;
                } else {
                    break;
                }
            }
        }
    }

    private static void check4(final int x, final int y, final int d1, final int d2) {
        for (int i = x + d1; i <= n; i++) {
            for (int j = n; j >= x - d2; j--) {
                if (area[i][j] == 0) {
                    area[i][j] = 4;
                } else {
                    break;
                }
            }
        }
    }

    private static void print(final int[][] now) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(now[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("#############");
    }

    /**
     * 게리맨더링 2
     * 최대한 공평하게 선거구를 확정하려고 한다.
     *
     * 재현시는 크기가 N * N인 격자로 나타낼 수 있다.
     * 격자의 각 칸은 구역을 의미하고, r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다.
     *
     * 구역을 다섯 개의 선거구로 나눠야 하고, 각 구역은 다섯 선거구 중 하나에 포함되어야 한다.
     * 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다.
     * 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다.
     * 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.
     *
     * 기준점 x, y와 경계의 길이 d1, d2를 정한다.
     * d1, d2 >= 1
     * 1 <= x < x + d1 + d2 <= N
     * 1 <= y-d1 < y < y + d2 <= N
     *
     * 다음 칸은 경계선이다.
     * 1. (x, y), (x+1, y-1), (x+d1, y-d1)
     * 2. (x, y), (x+1, y+1), (x+d2, y+d2)
     * 3. (x+d1, y-d1), (x+d1+1, y-d1+1), (x+d1+d2, y-d1+d2)
     * 4. (x+d2, y+d2), (x+d2+1, y+d2-1), (x+d2+d1, y+d2-d1)
     *
     * 경계선과 경계선의 안에 포함되어 있는 곳은 5번 선거구이다.
     * 5번 선거구에 포함되지 않은 구역의 선거구 번호는 다음 기준을 따른다.
     * 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
     * 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
     * 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
     * 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
     *
     * 1. 기준점 설정
     * 2. 구역 나누기
     * 3. 각 구역의 총 합
     * 4. 최솟값
     */
}