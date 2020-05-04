import java.io.*;
import java.util.*;

/**
 * Created by ds on 2019-04-12 오전 11:34.
 */

public class Main {

    private static int[][] arr;
    private static boolean[] visit;
    private static int n, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        n = Integer.parseInt(sc.nextLine());
        res = Integer.MAX_VALUE;

        arr = new int[n][n];
        visit = new boolean[n];

        for(int i = 0; i < n;i++) {
            st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0);

        System.out.println(res);
    }


    private static void func(final int x, final int count) {
        if(count == n/2) {
            int asum = 0;
            int bsum = 0;
            ArrayList<Integer> alist = new ArrayList<>();
            ArrayList<Integer> blist = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(!visit[i]) {
                    alist.add(i);
                }
                else {
                    blist.add(i);
                }
            }
            for(int i : alist) {
                for(int j : alist) {
                    if(i == j) continue;
                    asum += arr[i][j];
                }
            }
            for(int i : blist) {
                for(int j : blist) {
                    if(i == j) continue;
                    bsum += arr[i][j];
                }
            }
            res = Math.min(res, Math.abs(asum - bsum));
            return;
        }
        for(int i = x; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                func(i+1, count + 1);
                visit[i] = false;
            }
        }
    }

}