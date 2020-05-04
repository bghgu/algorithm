package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by ccoli on 2020/05/03.
 */

public class Main_2580 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    private static List<Pair> list = new ArrayList<>();
    private static int[][] arr = new int[9][9];

    public static void main(String... args) throws IOException {
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }

        boolean[] visit;

        List<Pair> tempList = new LinkedList<>();

        for (Pair p : list) {
            visit = new boolean[10];
            for (int i = 0; i < 9; i++) {
                visit[arr[i][p.y]] = true;
            }
            for (int i = 1; i <= 9; i++) {
                if (!visit[i]) {
                    p.set.add(i);
                }
            }
            visit = new boolean[10];
            for (int i = 0; i < 9; i++) {
                visit[arr[p.x][i]] = true;
            }
            for (int i = 1; i <= 9; i++) {
                if (!visit[i]) {
                    p.set.add(i);
                }
            }
            if (p.set.size() == 1) {
                arr[p.x][p.y] = (int) p.set.toArray()[0];
            } else {
                tempList.add(p);
            }
        }

        list = tempList;

        for (Pair p : list) {
            System.out.println(p.toString());
        }

        func(0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static boolean func(int index) {
        if (index == list.size()) {
            if (check()) {
                print();
                return true;
            }
            return false;
        }
        Pair p = list.get(index);
        for (int i : p.set) {
            arr[p.x][p.y] = i;
            func(index + 1);
        }
        return false;
    }

    private static boolean check() {
        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        for (int i = 0; i < 9; i++) {
            if (!check1(i)) {
                check1 = false;
                break;
            }
        }
        if (!check1) {
            return false;
        }
        for (int j = 0; j < 9; j++) {
            if (check2(j)) {
                check2 = false;
                break;
            }
        }
        if (!check2) {
            return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (check3(i, j)) {
                    check3 = false;
                    break;
                }
            }
        }
        return check3;
    }

    private static boolean check1(final int x) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            set.add(arr[x][j]);
        }
        return set.size() == 9;
    }

    private static boolean check2(final int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.add(arr[i][y]);
        }
        return set.size() == 9;
    }

    private static boolean check3(final int x, final int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                set.add(arr[i][j]);
            }
        }
        return set.size() == 9;
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static class Pair {

        private int x;
        private int y;
        private Set<Integer> set = new HashSet<>();

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                "x=" + x +
                ", y=" + y +
                ", set=" + set +
                '}';
        }
    }

    /**
     * 스도쿠
     * 가로 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄진다.
     * 게임 시작 전 몇 몇 칸에는 1부터 9까지 숫자 중 하나가 쓰여 있다.
     *
     * 나머지 빈 칸을 채우는 방식은 다음과 같다.
     * 1. 각각의 가로줄과 세로줄에는 1부터 9까지 숫자가 한 번씩만 나타나야 한다.
     * 2. 굵은 선으로 구분되어 있는 3 * 3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
     *
     *
     */
}