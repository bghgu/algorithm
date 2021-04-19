package leetcode.medium;

import java.util.Arrays;

/**
 * Created by ds on 2021/04/20
 * https://leetcode.com/problems/finding-the-users-active-minutes/
 */

public class Solution_1817 {

    public static void main(String... args) {
        int[][] arr1 = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int[][] arr2 = {{305589003,4136},{305589004,4139},{305589004,4141},{305589004,4137},{305589001,4139},{305589001,4139}};
        int[][] arr3 = {{205740660,1}};
        System.out.println(Arrays.toString(findingUsersActiveMinutes(arr1, 5)));
        System.out.println(Arrays.toString(findingUsersActiveMinutes(arr2, 6)));
        System.out.println(Arrays.toString(findingUsersActiveMinutes(arr3, 17016)));
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return o1[1] - o2[1];
            }
        });

        int lastIndex = logs[0][0];
        int lastValue = logs[0][1];
        int count = 1;
        int[] result = new int[k];

        for (int i = 1; i < logs.length; i++) {
            int nowIndex = logs[i][0];
            int nowValue = logs[i][1];

            if (lastIndex != nowIndex) {
                result[count - 1]++;
                count = 1;
                lastIndex = nowIndex;
                lastValue = nowValue;
            } else {
                if (lastValue != nowValue) {
                    lastValue = nowValue;
                    count++;
                }
            }
        }

        result[count - 1]++;

        return result;
    }

    /**
     * you are given the logs for users actions on leetCode, and an integer k.
     *
     * the logs are represented by a 2d integer array logs where each logs[i] = [IDi, timei]
     * indicates that the user with IDi performed an action at the minute timei.
     *
     * multiple users can perform actions simultaneously, and a single user can perform
     * multiple actions in the same minute.
     *
     * the user active minutes(UAM) for a given user is defined as the number of unique minutes
     * in which the user performed an action on LeetCode.
     *
     * A minute can only be counted once, even if multiple actions occur during it.
     *
     * you are to calculate a 1 - indexed array answer of size k such that, for each j (l <= j <= k)
     * answer[j] is the number of users whose UAM equals j.
     *
     * return the array answer as described above.
     */
}