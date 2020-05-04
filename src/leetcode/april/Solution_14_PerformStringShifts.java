package leetcode.april;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccoli on 2020/04/22.
 */

public class Solution_14_PerformStringShifts {

    public static void main(String... args) {
        String str1 = "abc";
        int[][] arr1 = {{0, 1}, {1, 2}};
        String str2 = "abcdefg";
        int[][] arr2 = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        String str3 = "mecsk";
        int[][] arr3 = {{1,4},{0,5},{0,4},{1,1},{1,5}};
        System.out.println(stringShift(str1, arr1));
        System.out.println(stringShift(str2, arr2));
        System.out.println(stringShift(str3, arr3));
    }

    public static String stringShift(String s, int[][] shift) {
        List<String> list = Arrays.asList(s.split(""));
        for (int i = 0; i < shift.length; i++) {
            int dir = shift[i][0];
            int amount = shift[i][1];
            List<String> temp = new LinkedList<>();
            //좌로 이동
            if (dir == 0) {
                for (int j = amount; j < list.size(); j++) {
                    temp.add(list.get(j));
                }
                for (int j = 0; j < amount; j++) {
                    temp.add(list.get(j));
                }
            }
            //우로 이동
            else {
                Collections.reverse(list);

                for (int j = amount; j < list.size(); j++) {
                    temp.add(list.get(j));
                }
                for (int j = 0; j < amount; j++) {
                    temp.add(list.get(j));
                }
                Collections.reverse(temp);
            }
            list = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }
}