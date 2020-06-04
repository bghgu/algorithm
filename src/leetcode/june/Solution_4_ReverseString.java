package leetcode.june;

/**
 * Created by ccoli on 2020/06/04.
 */

public class Solution_4_ReverseString {

    public static void main(String... args) {
        char[] str1 = {'h', 'e', 'l', 'l', 'o'};
        char[] str2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(str1);
        reverseString(str2);
    }

    public static void reverseString(char[] s) {
        char temp = 0;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}