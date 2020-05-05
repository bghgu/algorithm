package leetcode.may;

/**
 * Created by ccoli on 2020/05/05.
 */

public class Solution_1_FirstBadVersion {

    public static void main(String... args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(final int version) {
        return version > 3;
    }

}