package leetcode.june;

import java.util.Arrays;

/**
 * Created by ccoli on 2020/06/25.
 */

public class Solution_25_FindTheDuplicateNumber {

    public static void main(String... args) {

    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (last == nums[i]) {
                return last;
            }else {
                last = nums[i];
            }
        }
        return last;
    }
}