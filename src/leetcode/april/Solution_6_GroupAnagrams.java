package leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ccoli on 2020/04/16.
 */

public class Solution_6_GroupAnagrams {

    public static void main(String... args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String[] temp = s.split("");
            Arrays.sort(temp);
            String key = Arrays.toString(temp);
            if (map.containsKey(key)) {
                map.get(key).add(s);
                Collections.sort(map.get(key));
            }else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                lists.add(stringList);
                map.put(key, stringList);
            }
        }
        return lists;
    }
}