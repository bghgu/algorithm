package leetcode.medium;

import java.util.*;

/**
 * Created by ds on 2021/04/11.
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */

public class Solution_1282 {

    public static void main(String... args) {
        System.out.println(groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
        System.out.println(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int n = groupSizes[i];
            if (set.contains(n)) {
                map.get(n).add(i);
            }else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                set.add(n);
                map.put(n, list);
            }
        }

        List<List<Integer>> result = new LinkedList<>();

        for (int key : map.keySet()) {
            List<Integer> now = new LinkedList<>();
            for (int i : map.get(key)) {
                now.add(i);
                if (now.size() == key) {
                    result.add(now);
                    now = new LinkedList<>();
                }
            }
            if (!now.isEmpty()) result.add(now);
        }

        return result;
    }

    /**
     * there are n people that are split into some unknown number of groups.
     *
     * each person is labeled with a unique id from 0 to n - 1;
     *
     * you are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
     *
     * for example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
     *
     * return a list of groups such that each person i is in a group of size groupSizes[i]
     *
     * each person should appear in exactly one group, and every person must be in a group.
     *
     * if there are multiple answers, return any of them.
     *
     * it is guaranteed that there will be at least one valid solution for the given input.
     *
     */
}