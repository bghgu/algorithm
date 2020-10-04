package leetcode.september;

/**
 * Created by ccoli on 2020/09/11.
 */

public class Solution_11_MaximumProductSubarray {

    public static void main(String... args) {
        int[] arr1 = {2, 3, -2, 4};
        int[] arr2 = {-2, 0, -1};
        System.out.println(maxProduct(arr1));
        System.out.println(maxProduct(arr2));
    }

    public static int maxProduct(int[] nums) {
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            result = Math.max(result, max);
        }

        return result;
    }
}