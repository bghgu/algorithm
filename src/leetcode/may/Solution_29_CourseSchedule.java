package leetcode.may;

import java.util.ArrayList;
import java.util.List;

public class Solution_29_CourseSchedule {

    public static void main(String... args) {
        int[][] arr1 = {{1, 0}};
        int[][] arr2 = {{1, 0}, {0, 1}};
        int[][] arr3 = {{1, 0}, {2, 0}, {0, 2}};
        int[][] arr4 = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        int[][] arr5 = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(canFinish(2, arr1));
        System.out.println(canFinish(2, arr2));
        System.out.println(canFinish(3, arr3));
        System.out.println(canFinish(4, arr4));
        System.out.println(canFinish(3, arr5));
    }

    //[1, 0] => 1을 수강하려면 0을 수강했어야 한다.

    private static List<List<Integer>> list;
    private static boolean[] visit;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new boolean[numCourses];
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            list.get(a).add(b);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!list.get(i).isEmpty()) {
                visit = new boolean[numCourses];
                visit[i] = true;
                if (!dfs(i, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfs(final int x, final int start) {
        boolean flag = true;
        final List<Integer> list2 = list.get(x);
        for (int i : list2) {
            if (i == start) return false;
            if (!visit[i]) {
                visit[i] = true;
                flag = dfs(i, start);
            }
        }
        return flag;
    }
}
