package leetcode.september;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ccoli on 2020/09/07.
 */

public class Solution_7_WordPattern {

    public static void main(String... args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("", "beef"));
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int n = pattern.length();

        String[] pattern1 = pattern.split("");
        String[] str1 = str.split(" ");

        if (pattern1.length != str1.length || pattern.isEmpty() || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            String key = pattern1[i];
            String value = str1[i];

            if (map.containsKey(key)) {
                if (!map.get(key).equals(value)) {
                    return false;
                }
            }else {
                if (set.contains(value)) {
                    return false;
                }else {
                    map.put(key, value);
                    set.add(value);
                }
            }
        }

        return true;
    }
}