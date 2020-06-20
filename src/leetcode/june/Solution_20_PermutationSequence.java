package leetcode.june;

/**
 * Created by ccoli on 2020/06/20.
 */

public class Solution_20_PermutationSequence {

    public static void main(String... args) {
        getPermutation(3, 3);
        getPermutation(4, 9);
    }

    private static int[] order;
    private static boolean[] visit;
    private static int now = 0;
    private static String result = "";

    public static String getPermutation(int n, int k) {
        now = 0;
        result = "";
        order = new int[n + 1];
        visit = new boolean[n + 1];
        func(0, n, k);
        return result;
    }

    private static void func(final int count, final int max, final int k) {
        if (now > k) return;
        if (count == max) {
            now++;
            if (now == k) {
                for (int i = 0; i < max; i++) {
                    result += order[i];
                }
            }else return;
        }
        for (int i = 0; i < max; i++) {
            if (!visit[i + 1]) {
                visit[i + 1] = true;
                order[count] = i + 1;
                func(count + 1, max, k);
                visit[i + 1] = false;
            }
        }
    }
}