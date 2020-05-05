package leetcode.may;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccoli on 2020/05/05.
 */

public class Solution_3_RansomNote {

    public static void main(String... args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("", "a"));;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals("")) return true;
        Map<String, Integer> map = new HashMap<>();
        String[] str = ransomNote.split("");
        for (String s1 : str) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }
        for (String s : magazine.split("")) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                if (count > 0) {
                    map.put(s, count - 1);
                }
            }
        }
        int count = map.keySet().stream().mapToInt(map::get).sum();
        return count == 0;
    }
}