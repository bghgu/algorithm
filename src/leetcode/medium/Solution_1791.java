package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ds on 2021/04/11.
 * https://leetcode.com/problems/find-center-of-star-graph/
 */

public class Solution_1791 {

    public static void main(String... args) {
        int[][] arr1 = new int[][] {{1, 2}, {2, 3}, {4, 2}};
        int[][] arr2 = new int[][] {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(findCenter(arr1));
        System.out.println(findCenter(arr2));
    }

    public static int findCenter(int[][] edges) {
        int length = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            for (int j = 0; j < 2; j++) {
                int n = edge[j];
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == length) return key;
        }
        return 0;
    }

    /**
     * there is an undirected star graph consisting of n nodes labeled from 1 to n.
     *
     * A star graph is a graph where there is one center node and exactly n - 1 edges
     * that connect the center node with every other node.
     *
     * you are given a 2d integer array edges where each edges[i] = [ui, vi] indicates that
     * there is an edge between the nodes ui and vi.
     *
     * return the center of the given star graph
     */
}