package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2021/04/19
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */

public class Solution_797 {

    public static void main(String... args) {
        int[][] arr1 = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> list1 = allPathsSourceTarget(arr1);
        for (List<Integer> list : list1) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int n;
    private static int[][] arr;
    private static List<List<Integer>> result;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;

        arr = new int[n][n];

        result = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int b = graph[i][j];
                arr[i][b] = 1;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(0, list);

        return result;
    }

    private static void dfs(final int x, final LinkedList<Integer> list) {
        if (x == n - 1) {
            result.add(new LinkedList<>(list));
        }
        for (int i = 0; i < n; i++) {
            if (arr[x][i] == 1) {
                list.add(i);
                dfs(i, list);
                list.removeLast();
            }
        }
    }

    /**
     * given a directed acyclic graph (DAG) of n nodes labeled from 0 to n-1, find all possible paths
     * from node 0 to node n-1, and return them in any order.
     *
     * the graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e. there is a
     * directed edge from node i to node graph[i][j] ).
     */
}