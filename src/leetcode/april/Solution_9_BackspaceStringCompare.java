package leetcode.april;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ccoli on 2020/04/17.
 */

public class Solution_9_BackspaceStringCompare {

    public static void main(String... args) {
        String s = "ab#c";
        String t = "ad#c";
        String s1 = "isfcow#";
        String t1 = "isfco#w#";
        String s2 = "bxj##tw";
        String t2 = "bxj###tw";
        //System.out.println(backspaceCompare(s, t));
        //System.out.println(backspaceCompare(s1, t1));
        System.out.println(backspaceCompare(s2, t2));
    }

    public static boolean backspaceCompare(String S, String T) {
        final Deque<String> deque1 = func(S.split(""));
        final Deque<String> deque2 = func(T.split(""));
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            if (!deque1.poll().equals(deque2.poll())) return false;
        }
        return (deque1.isEmpty() && deque2.isEmpty());
    }

    private static Deque<String> func(final String[] str) {
        final Deque<String> deque = new ArrayDeque<>();
        for (String s : str) {
            if (s.equals("#")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pop());
                    //deque.pop();
                }
            } else {
                deque.push(s);
            }
        }
        return deque;
    }
}