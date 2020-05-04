package leetcode.may;

/**
 * Created by ccoli on 2020/05/04.
 */

public class Solution_4_NumberComplement {

    public static void main(String... args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement(2));
    }

    public static int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (String s : str.split("")) {
            if (s.equals("1")) sb.append(0);
            else sb.append(1);
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}