package leetcode.may;

/**
 * Created by ccoli on 2020/05/09.
 */

public class Solution_9_ValidPerfectSquare {

    public static void main(String... args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }

    public static boolean isPerfectSquare(int num) {
        double res1 = Math.pow(num, 0.5);
        int res2 = (int) Math.pow(num, 0.5);
        return res1 == res2;
    }
}