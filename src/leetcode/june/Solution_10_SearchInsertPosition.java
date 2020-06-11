package leetcode.june;

/**
 * Created by ccoli on 2020/06/10.
 */

public class Solution_10_SearchInsertPosition {

    public static void main(String... args) {
        int[] arr1 = {1, 3, 5, 6};
        System.out.println(searchInsert(arr1, 5));
        System.out.println(searchInsert(arr1, 2));
        System.out.println(searchInsert(arr1, 7));
        System.out.println(searchInsert(arr1, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}