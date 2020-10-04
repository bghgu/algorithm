package leetcode.september;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ccoli on 2020/09/09.
 */

public class Solution_9_CompareVersionNumbers {

    public static void main(String... args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("7.52.2.4", "7.51.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
    }

    public static int compareVersion(String version1, String version2) {
        List<Integer> arr1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> arr2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Math.max(arr1.size(), arr2.size());

        while (arr1.size() != n) {
            arr1.add(0);
        }

        while (arr2.size() != n) {
            arr2.add(0);
        }

        for (int i = 0; i < n; i++) {
            if (arr1.get(i) > arr2.get(i)) {
                return 1;
            } else if (arr1.get(i) < arr2.get(i)) {
                return -1;
            }
        }

        return 0;
    }
}