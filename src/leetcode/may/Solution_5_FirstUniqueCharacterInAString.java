package leetcode.may;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ccoli on 2020/05/06.
 */

public class Solution_5_FirstUniqueCharacterInAString {

    public static void main(String... args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("dddccdbba"));
    }

    public static int firstUniqChar(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        int index = -1;

        for (String str : s.split("")) {
            index++;
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
                map1.put(str, index);
            }
        }

        String key = map.keySet().stream().filter(str -> map.get(str) == 1).findFirst().orElse("");

        if (key.equals("")) {
            return -1;
        } else {
            return map1.get(key);
        }
    }
}