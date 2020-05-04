package leetcode.april;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ccoli on 2020/04/16.
 */

public class Solution_7_CountingElements {

    public static void main(String... args) {
        final int[] arr1 = {1, 2, 3};
        final int[] arr2 = {1, 1, 3, 3, 5, 5, 7, 7};
        final int[] arr3 = {1, 3, 2, 3, 5, 0};
        final int[] arr4 = {1, 1, 2, 2};
        final int[] arr5 = {1, 1, 2};
        final int[] arr6 = {1, 3, 2, 3, 5, 0};
        final int[] arr7 = {2, 9, 0, 7, 6, 2, 7, 7, 0};
//        System.out.println(countElements(arr1));
//        System.out.println(countElements(arr2));
//        System.out.println(countElements(arr3));
//        System.out.println(countElements(arr4));
//        System.out.println(countElements(arr5));
//        System.out.println(countElements(arr6));
        System.out.println(countElements(arr7));
    }

    public static int countElements(final int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int temp = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                temp++;
            } else if (arr[i] + 1 == arr[i + 1]) {
                count += temp;
                temp = 1;
            } else {
                temp = 1;
            }
        }
        return count;
    }
}