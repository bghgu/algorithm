package leetcode.topInterviewQuestion;

/**
 * Created by ccoli on 2020/05/30.
 */

public class RemoveDuplicatesFromSortedArray {

    public static void main(String... args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int last = 0;
        if (nums.length != 0) {
            last = nums[0] -1;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (last != nums[i]) {
                last = nums[i];
                nums[index++] = last;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = last;
        }
        return index;
    }
}