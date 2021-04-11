package beakjoon; /**
 * Created by ccoli on 2020/10/23.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_단풍놀이 {

    private static int N;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int result = Integer.MIN_VALUE;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        //5
        //YCPZY
        //CYZZP
        //CCPPP
        //YCYZC
        //CPPZZ

        // 나뭇잎의 색이 다른 인접한 두 칸을
//       * 고른 뒤에, 두 칸에 있는 나뭇잎을 교환합니다. 그런 다음, 가로 또는 세로로 모두 연속적으로 같은 색인 나뭇잎을 가져올 수 있습니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (arr[i][j] != arr[nx][ny]) {
                            swap(i, j, nx, ny);
                            int now = find(i, j);
                            System.out.println(i + " " + j + " " + now);
                            result = Math.max(result, find(i, j));
                            swap(nx, ny, i, j);
                        }
                    }
                }
                break;

            }
            break;
        }

        System.out.println(result);

    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char c = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = c;
    }

    private static int find(int x, int y) { // 찾기

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int count = 1;
        char cc = arr[x][y];

        Queue<Pair> q = new LinkedList<>(); // LinkedList
        q.offer(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            System.out.println(p.toString());
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && 0 <= ny && nx < N && ny < N && !visited[nx][ny]) {
                    if (cc == arr[nx][ny]) {
                        System.out.println(cc + " " + arr[nx][ny]);
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}