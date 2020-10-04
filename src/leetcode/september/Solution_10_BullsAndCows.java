package leetcode.september;

/**
 * Created by ccoli on 2020/09/11.
 */

public class Solution_10_BullsAndCows {

    public static void main(String... args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("1123", "0012"));
    }

    public static String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;

        String[] str1 = secret.split("");
        String[] str2 = guess.split("");

        int[] count1 = new int[10];
        int[] count2 = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (str1[i].equals(str2[i])) {
                A++;
            } else {
                count1[Integer.parseInt(str1[i])]++;
                count2[Integer.parseInt(str2[i])]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (count1[i] > 0 && count2[i] > 0) {
                B += Math.min(count1[i], count2[i]);
            }
        }

        return A + "A" + B + "B";
    }
}