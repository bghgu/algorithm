package leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccoli on 2020/05/19.
 */

public class Solution_19_OnlineStockSpan {

    public static void main(String... args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
        System.out.println("#######");
        StockSpanner obj2 = new StockSpanner();
        System.out.println(obj2.next(29));
        System.out.println(obj2.next(91));
        System.out.println(obj2.next(62));
        System.out.println(obj2.next(76));
        System.out.println(obj2.next(51));
    }

    //100, 80, 60, 70, 60, 75, 85
    //1, 1, 1, 2, 1, 4, 6
    private static class StockSpanner {

        private List<Integer> list;
        private int index = -1;

        public StockSpanner() {
            list = new ArrayList<>();
        }

        public int next(int price) {
            index++;
            list.add(price);
            int count = 0;

            for (int i = index; i >= 0; i--) {
                if (list.get(i) <= price) count++;
                else break;
            }

            return count;
        }
    }
}