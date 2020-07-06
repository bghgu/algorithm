package leetcode.july;

/**
 * Created by ccoli on 2020/07/05.
 */

public class Solution_5_HammingDistance {

    public static void main(String... args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        String temp = "";
        for (int i = 0; i < a.length() - b.length(); i++) {
            temp += "0";
        }
        temp += b;
        b = temp;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}