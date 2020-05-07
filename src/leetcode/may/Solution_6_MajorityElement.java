package leetcode.may;

import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccoli on 2020/05/06.
 */

public class Solution_6_MajorityElement {

    public static void main(String... args) {
        int[] arr1 = {3, 2, 3};
        int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr1));
        System.out.println(majorityElement(arr2));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        stream(nums).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });

        int max = -1;
        int result = 0;

        for (int i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                result = i;
            }
        }

        return result;
    }
}