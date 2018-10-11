package leetcode.question19;

import leetcode.util.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode headptr = head;

        while(n>0) {
            head=head.next;
            n--;
        }

        while(head!=null) {
            headptr = headptr.next;
            head = head.next;
        }

        headptr.val=headptr.next.val;
        headptr.next = headptr.next.next;

        return result;
    }
}
