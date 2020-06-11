package leetcode.june;

import java.util.Arrays;

/**
 * Created by ccoli on 2020/06/11.
 */

public class Solution_11_SortColors {

    public static void main(String... args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1};
        sortColors(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {2, 0};
        sortColors(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            count[i] = -1;
        }
        for (int i : nums) {
            if (count[i] == -1) {
                count[i] = 0;
            }
            count[i]++;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (count[index] == -1) {
                index++;
            }
            nums[i] = index;
            count[index]--;
            if (count[index] == 0) {
                index++;
            }
        }
    }
}