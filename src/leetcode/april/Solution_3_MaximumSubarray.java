package leetcode.april;

/**
 * Created by ccoli on 2020/04/09.
 */

public class Solution_3_MaximumSubarray {

    public static void main(String... args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {-2, -1};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray(arr2));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int s = 0;
        int e = 0;
        while (s <= e) {
            if (max <= sum) {
                max = sum;
                e++;
            }
            else {
                sum -= nums[s];
                s++;
            }
        }

        return max;
    }
}