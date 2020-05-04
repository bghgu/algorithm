package leetcode.april;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ccoli on 2020/04/22.
 */

public class Solution_13_ContiguousArray {

    public static void main(String... args) {
        int[] arr1 = {0, 1};
        int[] arr2 = {0, 1, 0};
        int[] arr3 = {0, 1, 2, 3, 4};
        int[] arr4 = {0, 1, 0, 1, 4};
        int[] arr5 = {1, 0, 1, 0, 4};
        int[] arr6 = {1, 0, 0, 0, 4};
        int[] arr7 = {1, 1, 1, 0, 4};
        int[] arr8 = {0, 0, 0, 1, 4};
        int[] arr9 = {0, 0, 0, 1, 1, 1, 0};
        int[] arr10 = {0, 0, 1, 0, 0, 0, 1, 1};
//        System.out.println(findMaxLength(arr1));
//        System.out.println(findMaxLength(arr2));
//        System.out.println(findMaxLength(arr3));
//        System.out.println(findMaxLength(arr4));
//        System.out.println(findMaxLength(arr5));
//        System.out.println(findMaxLength(arr6));
//        System.out.println(findMaxLength(arr7));
//        System.out.println(findMaxLength(arr8));
        System.out.println(findMaxLength(arr9));
        System.out.println(findMaxLength(arr10));
    }

    public static int findMaxLength(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count0++;
                } else if (nums[j] == 1){
                    count1++;
                }
                if (count0 == count1) {
                    result = Math.max(result, count0 + count1);
                }
            }
        }

        return result;
    }

}