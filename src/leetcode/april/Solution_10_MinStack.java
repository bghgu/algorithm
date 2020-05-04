package leetcode.april;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by ccoli on 2020/04/18.
 */

public class Solution_10_MinStack {

    public static void main(String... args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    static class MinStack {
        private Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            List<Integer> temp = (Stack<Integer>) stack.clone();
            Collections.sort(temp);
            return temp.get(0);
        }
    }
}