package leetcode.june;

import java.util.Random;

/**
 * Created by ccoli on 2020/06/05.
 */

public class Solution_5_RandomPickWithWeight {

    public static void main(String... args) {
        Solution obj1 = new Solution(new int[]{1});
        int param_1 = obj1.pickIndex();
        Solution obj2 = new Solution(new int[]{1, 3});
        int param_2 = obj2.pickIndex();
    }

    public static class Solution {

        private Random random;
        private int[] sum;

        public Solution(int[] w) {
            this.random = new Random();
            for (int i = 1; i < w.length; ++i) {
                w[i] += w[i - 1];
            }
            this.sum = w;
        }


        public int pickIndex() {
            int len = sum.length;
            int index = random.nextInt(sum[len - 1]) + 1;
            int start = 0;
            int end = len - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (sum[mid] == index) {
                    return mid;
                } else if (sum[mid] < index) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return start;
        }
    }
}