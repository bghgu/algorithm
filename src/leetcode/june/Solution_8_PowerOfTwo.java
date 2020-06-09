package leetcode.june;

/**
 * Created by ccoli on 2020/06/09.
 */

public class Solution_8_PowerOfTwo {

    public static void main(String... args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        int x = (int) (Math.log(n) / Math.log(2));
        long y = (long) Math.pow(2, x);
        return y == n;
    }
}