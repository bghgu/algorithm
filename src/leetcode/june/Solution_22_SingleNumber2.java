package leetcode.june;

import java.util.Arrays;

/**
 * Created by ccoli on 2020/06/22.
 */

public class Solution_22_SingleNumber2 {

    public static void main(String... args) {
        int[] arr1 = {2, 2, 3, 2};
        int[] arr2 = {0, 1, 0, 1, 0, 1, 99};
        int[] arr3 = {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
        System.out.println(singleNumber(arr3));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int answer = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (answer != nums[i]) {
                if (count == 1) {
                    return answer;
                }
                answer = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        return answer;
    }
}