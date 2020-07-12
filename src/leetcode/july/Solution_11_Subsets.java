package leetcode.july;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/07/12.
 */

public class Solution_11_Subsets {

    public static void main(String... args) {
        int[] arr1 = {1, 2, 3};
        System.out.println(subsets(arr1));
    }

    private static List<List<Integer>> result;
    private static int[] arr;
    private static boolean[] visit;
    private static int n;

    public static List<List<Integer>> subsets(int[] nums) {
        arr = nums;
        n = nums.length;
        result = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            visit = new boolean[n];
            func(0, i);
        }
        return result;
    }

    private static void func(final int count, final int max) {
        if (count == max) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    list.add(arr[i]);
                }
            }
            result.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                func(count + 1, max);
                visit[i] = false;
            }else return;
        }
    }
}