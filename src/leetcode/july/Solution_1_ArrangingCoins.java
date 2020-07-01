package leetcode.july;

/**
 * Created by ccoli on 2020/07/01.
 */

public class Solution_1_ArrangingCoins {

    public static void main(String... args) {
        //System.out.println(arrangeCoins(8));
        //System.out.println(arrangeCoins(5));
        //System.out.println(arrangeCoins(1));
        //System.out.println(arrangeCoins(0));
        //System.out.println(arrangeCoins(3));
        System.out.println(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        long left = 0, right = n;
        long k, curr;
        while (left <= right) {
            k = left + (right - left) / 2;
            curr = k * (k + 1) / 2;

            if (curr == n) return (int) k;

            if (n < curr) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return (int) right;
    }
}