package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ccoli on 2020/03/21.
 */

public class Main_2997 {

    public static void main(String... args) {
        String[] str = new Scanner(System.in).nextLine().split(" ");
        Arrays.sort(str);
        final int a = Integer.parseInt(str[0]);
        final int b = Integer.parseInt(str[1]);
        final int c = Integer.parseInt(str[2]);

        // a X b c
        // a b X c
        if (b - a != c - b) {
            if (b - a > c - b) {
                System.out.println(a + (c - b));
            }else {
                System.out.println(b + (b - a));
            }
        }
        // a b c X
        else if (b - a == c - b) {
            System.out.println(c + (c - b));
        }
    }
}