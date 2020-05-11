package leetcode.april;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ccoli on 2020/04/02.
 */

public class Solution_1_SingleNumber {

    public static void main(String... args) {
        int[] arr = {2, 2, 1};
        int[] arr2 = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber(arr2));
    }

    private static int singleNumber(final int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) set.remove(i);
            else set.add(i);
        }
        return set.iterator().next();
    }
}