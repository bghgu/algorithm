package leetcode.april;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by ccoli on 2020/04/24.
 */

public class Solution_16_ValidParenthesisString {

    public static void main(String... args) {
        String str1 = "()";
        String str2 = "(*)";
        String str3 = "(*))";
    }

    public static boolean checkValidString(String s) {
        String[] temp = s.split("");
        Deque<String> stack = new ArrayDeque<>();
        boolean result = true;

        //*
        boolean check1 = false;
        //)
        boolean check2 = false;

        for (String str : temp) {
            if (str.equals("(") || str.equals("*")) {
                stack.push(str);
            } else {
                if (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (top.equals("(")) continue;
                    else if (top.equals(")")) {
                        if (stack.isEmpty()) result = false;
                        else {
                            String nextTop = stack.peek();
                            if (nextTop.equals("*")) continue;
                        }
                    }else {

                    }
                } else {
                    result = false;
                }
            }
        }

        return result;
    }

    /*
    왼쪽 괄호 '('에는 해당 오른쪽 괄호 ')'가 있어야합니다.

오른쪽 괄호 ')'에는 해당 왼쪽 괄호 '(')가 있어야합니다.

왼쪽 괄호 '('는 해당 오른쪽 괄호 ')'앞에 와야합니다.

'*'는 단일 오른쪽 괄호 ')'또는 단일 왼쪽 괄호 '('또는 빈 문자열로 처리 될 수 있습니다.

빈 문자열도 유효합니다.
     */
}