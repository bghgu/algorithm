package leetcode.july;

import java.util.*;

/**
 * Created by ccoli on 2020/07/04.
 */

public class Solution_4_UglyNumber2 {

    public static void main(String... args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(7));
        System.out.println(nthUglyNumber(1407));
    }

    public static int nthUglyNumber(int n) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        for (int i = 0; i <= n + 10; i++) {
            List<Integer> temp = new ArrayList<>(set);
            set.add(temp.get(i) * 2);
            set.add(temp.get(i) * 3);
            set.add(temp.get(i) * 5);
        }
        List<Integer> list = new ArrayList<>(set);
        return list.get(n-1);
    }
}