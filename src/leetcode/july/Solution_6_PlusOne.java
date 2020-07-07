package leetcode.july;

import java.util.Arrays;

/**
 * Created by ccoli on 2020/07/06.
 */

public class Solution_6_PlusOne {

    public static void main(String... args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 0})));
        System.out.println(Arrays.toString(plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6})));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int i, N = digits.length, sum;

        for (i = N - 1; i >= 0; --i) {
            sum = digits[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            digits[i] = sum;
        }

        if (carry == 0)
            return digits;
        else {
            int[] result = new int[N + 1];
            result[0] = carry;
            for (i = 1; i <= N; i++) {
                result[i] = digits[i - 1];
            }

            return result;
        }
    }
}