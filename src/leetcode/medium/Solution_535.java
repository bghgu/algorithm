package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ds on 2021/04/16.
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */

public class Solution_535 {

    public static void main(String... args) {
        String key = Codec.encode("!!!!");
        System.out.println(key);
        System.out.println(Codec.decode(key));
    }

    public static class Codec {

        private static Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public static String encode(String longUrl) {
            double key = Math.random();
            while (map.containsKey(String.valueOf(key))) {
                key = Math.random();
            }
            map.put(String.valueOf(key), longUrl);
            return String.valueOf(key);
        }

        // Decodes a shortened URL to its original URL.
        public static String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

    /**
     * Note : this is a companion problem to the system design problem: design TinyURL.
     *
     * TinyURL is a URL shortening service where you enter a URL such as
     * https://leetcode.com/problems/design-tinyurl
     * and it return a short URL such as http://tinyurl.com/4e9iAk
     *
     * Design the encode and decode methods for the TinyURL service.
     *
     * there is no restriction on how your encode/decode algorithm should work.
     *
     * you just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
     */
}