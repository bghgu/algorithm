package leetcode.may;

/**
 * Created by ccoli on 2020/05/16.
 */

public class Solution_16_OddEvenLinkedList {

    public static void main(String... args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        
    }

    public static ListNode oddEvenList(ListNode head) {
        return null;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}