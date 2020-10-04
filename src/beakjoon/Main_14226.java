package beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ccoli on 2020/09/01.
 * https://www.acmicpc.net/problem/14226
 */

public class Main_14226 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    //화면, 클립보드
    private static boolean[][] visit;

    public static void main(String... args) throws IOException {
        n = Integer.parseInt(br.readLine());

        visit = new boolean[1001][1001];

        bw.write(func() + "");
        bw.close();
        br.close();
    }

    private static int func() {
        Queue<Pair> queue = new LinkedList<>();
        visit[1][0] = true;
        queue.offer(new Pair(1, 0, 0));

        int result = 0;

        while (!queue.isEmpty()) {

            Pair p = queue.poll();

            if (p.count == n) return p.time;

            if (p.count != 0) {
                queue.offer(new Pair(p.count, p.count, p.time + 1));
            }

            if (p.count + p.clip <= 1000 && !visit[p.count + p.clip][p.clip] && p.clip > 0) {
                visit[p.count + p.clip][p.clip] = true;
                queue.offer(new Pair(p.count + p.clip, p.clip, p.time + 1));
            }

            if (p.count - 1 > 0 && !visit[p.count - 1][p.clip]) {
                visit[p.count - 1][p.clip] = true;
                queue.offer(new Pair(p.count - 1, p.clip, p.time + 1));
            }

        }

        return result;
    }

    private static class Pair {
        private int count;
        private int clip;
        private int time;

        public Pair(final int count, final int clip, final int time) {
            this.count = count;
            this.clip = clip;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "count=" + count +
                    ", clip=" + clip +
                    ", time=" + time +
                    '}';
        }
    }

    /**
     * 영선이는 매우 기쁘기 때문에 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.
     * 영선이는 이미 화면에 이모티콘 1개를 입력했다.
     * 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.
     *
     * 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
     * 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
     * 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
     *
     * 모든 연산은 1초가 걸린다.
     * 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있는 이전에 클립보드에 있던 내용은 덮어쓰기가 된다.
     * 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다.
     *
     * 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다.
     * 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.
     *
     * 영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성
     *
     * 2 <= S <= 1000
     */
}