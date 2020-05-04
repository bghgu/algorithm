package leetcode.april;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/04/09.
 */

public class Solution_4_MoveZeroes {

    public static void main(String... args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] arr2 = {2, 1};
        moveZeroes(arr);
        moveZeroes(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    public static void moveZeroes(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int count = 0;
        for (int i : nums) {
            if (i == 0) count++;
            else list.add(i);
        }

        int i = 0;
        for (; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int j = 0; j < count; j++) {
            nums[i++] = 0;
        }
    }
}