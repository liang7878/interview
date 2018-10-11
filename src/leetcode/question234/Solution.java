package leetcode.question234;

import leetcode.util.ListNode;

/*
*
* 1, 2, 3, 4, 5
* */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode fast = head, slow = head;

        while(slow!=null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tailStart = reverse(slow);

        while(head!=null) {
            if(head.val != tailStart.val) return false;
            head = head.next;
            tailStart = tailStart.next;
        }

        return true;
    }

    public ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;

        ListNode current = node;
        ListNode head = node.next;
        current.next = null;

        while(head!=null) {
            ListNode next= head.next;
            head.next = current;
            current = head;
            head = next;
        }

        return current;
    }
}
