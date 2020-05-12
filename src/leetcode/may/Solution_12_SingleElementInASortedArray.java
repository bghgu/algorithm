package leetcode.may;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ccoli on 2020/05/12.
 */

public class Solution_12_SingleElementInASortedArray {

    public static void main(String... args) {
        int[] arr1 = {1,1,2,3,3,4,4,8,8};
        int[] arr2 = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr1));
        System.out.println(singleNonDuplicate(arr2));
    }

    public static int singleNonDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) set.remove(i);
            else set.add(i);
        }
        return (int) set.toArray()[0];
    }
}