package leetcode.june;

import sun.net.util.IPAddressUtil;

/**
 * Created by ccoli on 2020/06/16.
 */

public class Solution_16_ValidateIPAddress {

    public static void main(String... args) {
        //System.out.println(validIPAddress("172.16.254.1"));
        //System.out.println(validIPAddress("172..254.1"));
        //System.out.println(validIPAddress("172.001.254.1"));
        //System.out.println(validIPAddress("172.00111111.254.1"));
        //System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        //System.out.println(validIPAddress("256.256.256.256"));
        //System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        //System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIPAddress("1081:db8:85a3:01:-0:8A2E:0370:7334"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    private static final String NEITHER = "Neither";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";

    public static String validIPAddress(String IP) {
        String[] origin;
        if (IP.contains(".")) {
            origin = IP.split("\\.");
            if ((origin.length != 4) || (IP.lastIndexOf(".") == (IP.length() - 1))) return NEITHER;
            for (String str : origin) {
                if (str.equals("") || str.length() > 3) {
                    return NEITHER;
                }
                int num = 0;
                try {
                    num = Integer.parseInt(str);
                }catch (Exception e) {
                    return NEITHER;
                }
                if ((num < 0 || num > 255) || (!String.valueOf(num).equals(str)) || str.equals("-0")) {
                    return NEITHER;
                }
            }
            return IPV4;
        }else if (IP.contains(":")) {
            origin = IP.split(":");
            if ((origin.length != 8) || (IP.lastIndexOf(":") == (IP.length() - 1))) return NEITHER;
            for (String str : origin) {
                if (str.equals("") || str.length() > 4) {
                    return NEITHER;
                }
                int num = 0;
                try {
                    num = Integer.parseInt(str, 16);
                }catch (Exception e) {
                    return NEITHER;
                }
                if ((num < 0 || num > 65535) || str.equals("-0")) {
                    return NEITHER;
                }
            }
            return IPV6;
        }
        return NEITHER;
    }
}