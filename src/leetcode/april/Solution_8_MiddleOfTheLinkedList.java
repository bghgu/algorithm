package leetcode.april;

/**
 * Created by ccoli on 2020/04/17.
 */

public class Solution_8_MiddleOfTheLinkedList {

    public static void main(String... args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(middleNode(listNode).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int mid = size / 2;
        temp = head;
        while (temp != null) {
            if (mid == 0) {
                return temp;
            }
            mid--;
            temp = temp.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}