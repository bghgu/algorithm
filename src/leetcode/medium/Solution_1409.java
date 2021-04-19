package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ds on 2021/04/16.
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/
 */

public class Solution_1409 {

    public static void main(String... args) {
        System.out.println(Arrays.toString(processQueries(new int[]{3, 1, 2, 1}, 5)));
    }

    public static int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= m; i++) linkedList.add(i);

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int idx = linkedList.indexOf(q);
            int val = linkedList.get(idx);
            linkedList.remove(idx);
            linkedList.addFirst(val);
            res[i] = idx;
        }

        return res;
    }

    /**
     * given the array queries of positive integers between 1 and m, you have to process all queries[i]
     * (from i=0 to i=queries.length-1) according to the following rules:
     *
     * in the beginning, you have the permutation p=[1, 2, ,, m]
     *
     * for the current i, find the position of queries[i] in the permutation p (indexing from 0) and
     * then move this at the beginning of the permutation p.
     *
     * notice that the position of queries[i] in p is the result for queries[i]
     */
}