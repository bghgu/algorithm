package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/04/04.
 */

public class Main_16935 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1: {
                    func1();
                    break;
                }
                case 2: {
                    func2();
                    break;
                }
                case 3: {
                    func3();
                    break;
                }
                case 4: {
                    func4();
                    break;
                }
                case 5: {
                    func5();
                    break;
                }
                case 6: {
                    func6();
                    break;
                }
            }
        }

        print();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void func1() {
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - i][j];
                arr[n - 1 - i][j] = temp;
            }
        }
    }

    private static void func2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][m - 1 - j];
                arr[i][m - 1 - j] = temp;
            }
        }
    }

    private static void func3() {
        int[][] temp = new int[m][n];
        int a = 0;
        int b = 0;
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                temp[a][b++] = arr[i][j];
                if (b == n) {
                    a++;
                    b = 0;
                }
            }
        }
        arr = temp;
        int temp2 = n;
        n = m;
        m = temp2;
    }

    private static void func4() {
        int[][] temp = new int[m][n];
        int a = 0;
        int b = 0;
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                temp[a][b++] = arr[i][j];
                if (b == n) {
                    a++;
                    b = 0;
                }
            }
        }
        arr = temp;
        int temp2 = n;
        n = m;
        m = temp2;
    }

    private static void func5() {
        //1백업
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                queue.add(arr[i][j]);
            }
        }
        //4 -> 1
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                arr[i - (n / 2)][j] = arr[i][j];
            }
        }
        //3 -> 4
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                arr[i][j - (m / 2)] = arr[i][j];
            }
        }
        //2 -> 3
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                arr[i + (n / 2)][j] = arr[i][j];
            }
        }
        //1 -> 2
        for (int i = 0; i < n /2; i++) {
            for (int j = m / 2; j < m; j++) {
                arr[i][j] = queue.poll();
            }
        }
    }

    private static void func6() {
        //1백업
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                queue.add(arr[i][j]);
            }
        }
        //2 -> 1
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                arr[i][j - (m / 2)] = arr[i][j];
            }
        }
        //3 -> 2
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                arr[i - (n / 2)][j] = arr[i][j];
            }
        }
        //4 -> 3
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                arr[i][j + (m / 2)] = arr[i][j];
            }
        }
        //1 -> 4
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                arr[i][j] = queue.poll();
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}